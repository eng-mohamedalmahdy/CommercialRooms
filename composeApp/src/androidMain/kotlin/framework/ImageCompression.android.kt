package framework

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

actual suspend fun platformCompressImage(byteArray: ByteArray, format: String, quality: Double): ByteArray {
    return compressImageAndroid(byteArray, Bitmap.CompressFormat.valueOf(format.uppercase()), quality.toInt())
}

actual suspend fun platformCompressImageToSize(byteArray: ByteArray, format: String, targetSizeKb: Int): ByteArray {
    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    val compressFormat = when (format.lowercase()) {
        "jpeg", "jpg" -> Bitmap.CompressFormat.JPEG
        "png" -> Bitmap.CompressFormat.PNG
        else -> throw IllegalArgumentException("Unsupported format: $format")
    }


    val targetSizeBytes = targetSizeKb * 1024
    val lowerBound = (targetSizeBytes * 0.9).toInt()
    val upperBound = (targetSizeBytes * 1.1).toInt()


    // Check if the image is already smaller than the lower bound
    if (byteArray.size <= upperBound) {
        return byteArray
    }
    var low = 0
    var high = 100



    while (low <= high) {
        val mid = (low + high) / 2
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(compressFormat, mid, outputStream)
        val compressedByteArray = outputStream.toByteArray()
        if (compressedByteArray.size in lowerBound..upperBound) {
            return compressedByteArray
        } else if (compressedByteArray.size < lowerBound) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return byteArray
}
fun compressImageAndroid(byteArray: ByteArray, format: Bitmap.CompressFormat, quality: Int): ByteArray {
    val inputStream = ByteArrayInputStream(byteArray)
    val originalImage = BitmapFactory.decodeStream(inputStream)

    val outputStream = ByteArrayOutputStream()
    originalImage.compress(format, quality, outputStream)

    return outputStream.toByteArray()
}

