package framework

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readBytes
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.jetbrains.skia.Data
import platform.Foundation.NSData
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSURL
import platform.Foundation.create
import platform.Foundation.writeToURL
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication
import platform.UIKit.UIImage

actual object ShareKit {
    private val mainScope = MainScope()
    private val client = HttpClient()

    actual suspend fun shareImage(image: String) {
        mainScope.launch {
            val imageData = fetchImage(image)
            shareImageData(imageData)
        }
    }

    private suspend fun fetchImage(url: String): ByteArray {
        return client.get(url).readBytes()
    }

    private fun shareImageData(imageData: ByteArray) {
        val data = imageData.toNSData()
        val temporaryDirectory = NSTemporaryDirectory()
        val filePath = temporaryDirectory + "shared_image.png"
        val fileUrl = NSURL.fileURLWithPath(filePath)

        if (data.writeToURL(fileUrl, true)) {
            val activityViewController = UIActivityViewController(activityItems = listOf(fileUrl), applicationActivities = null)
            val currentViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
            currentViewController?.presentViewController(activityViewController, animated = true, completion = null)
        }
    }

    actual fun shareText(text: String) {
        val currentViewController = UIApplication.sharedApplication().keyWindow?.rootViewController
        val activityViewController = UIActivityViewController(listOf(text), null)
        currentViewController?.presentViewController(
            viewControllerToPresent = activityViewController,
            animated = true,
            completion = null
        )
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun ByteArray.toNSData(): NSData {
        val pinned = this.usePinned {
            NSData.create(bytes = it.addressOf(0), length = this.size.toULong())
        }
        return pinned
    }
}