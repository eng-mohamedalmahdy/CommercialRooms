package framework

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import coil3.BitmapImage
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.request.ErrorResult
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import coil3.svg.SvgDecoder
import io.github.aakira.napier.Napier
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

private const val TAG = "ContentSharing.android"

actual object ShareKit {
    @OptIn(ExperimentalCoilApi::class)
    actual suspend fun shareImage(image: String) {
        val request = ImageRequest.Builder(activityProvider.invoke())
            .data(image)
            .decoderFactory(SvgDecoder.Factory())
            .target { result -> (result as BitmapImage).bitmap }
            .build()
        val loader = ImageLoader(activityProvider.invoke())
        Napier.d { "Image: $image" }
        when (val result = loader.execute(request)) {
            is SuccessResult -> {
                Napier.d { "Success" }
                val bitmap = (result.image as BitmapImage).bitmap
                val imageUri = saveImage(bitmap)
                try {
                    val sharingIntent = Intent(Intent.ACTION_SEND)
                    if (imageUri != null) {
                        activityProvider.invoke().contentResolver.openInputStream(imageUri)?.use {
                            sharingIntent.setType("image/jpeg")
                            sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
                            activityProvider.invoke().startActivity(Intent.createChooser(sharingIntent, "Share image using"))
                        }
                    }
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
            }

            is ErrorResult -> {
                Napier.d { "Failed ${result.throwable.message}" }
            }
        }

    }

    private var activityProvider: () -> Activity = {
        throw IllegalArgumentException(
            "You need to implement the 'activityProvider' to provide the required Activity. " +
                    "Just make sure to set a valid activity using " +
                    "the 'setActivityProvider()' method."
        )
    }

    fun setActivityProvider(provider: () -> Activity) {
        activityProvider = provider
    }

    actual fun shareText(text: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        val intentChooser = Intent.createChooser(intent, null)
        activityProvider.invoke().startActivity(intentChooser)
    }

    private fun saveImage(image: Bitmap): Uri? {
        val imagesFolder = File(activityProvider.invoke().cacheDir, "images")
        var uri: Uri? = null
        try {
            imagesFolder.mkdirs()
            val file = File(imagesFolder, "shared_image.png")

            val stream = FileOutputStream(file)
            image.compress(Bitmap.CompressFormat.PNG, 90, stream)
            stream.flush()
            stream.close()
            uri = FileProvider.getUriForFile(activityProvider.invoke(), "com.thekupe.ugate", file)
        } catch (e: IOException) {
            Log.d(TAG, "IOException while trying to write file for sharing: " + e.message)
        }
        return uri
    }

}
