@file:OptIn(BetaInteropApi::class, ExperimentalForeignApi::class)

package framework

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.create
import platform.UIKit.UIImage
import platform.UIKit.UIImageJPEGRepresentation
import platform.UIKit.UIImagePNGRepresentation
import platform.posix.memcpy

actual suspend fun platformCompressImage(byteArray: ByteArray, format: String, quality: Double): ByteArray {
    return compressImageIos(byteArray, quality)
}

fun compressImageIos(byteArray: ByteArray, quality: Double = 0.8): ByteArray {
    val nsData = byteArray.toNSData()
    val originalImage = UIImage(nsData)

    val compressedData = UIImageJPEGRepresentation(originalImage, quality) ?: error("Failed to compress UIImage")
    return compressedData.toByteArray()
}

fun ByteArray.toNSData(): NSData {
    return this.usePinned { pinned ->
        NSData.create(bytes = pinned.addressOf(0), length = this.size.toULong())
    }
}

fun NSData.toByteArray(): ByteArray {
    val size = this.length.toInt()
    val byteArray = ByteArray(size)
    byteArray.usePinned { pinned ->
        memcpy(pinned.addressOf(0), this.bytes, size.convert())
    }
    return byteArray
}

actual suspend fun platformCompressImageToSize(byteArray: ByteArray, format: String, targetSizeKb: Int): ByteArray {
    val uiImage = UIImage(byteArray.toNSData())
    val targetSizeBytes = targetSizeKb * 1024
    val lowerBound = (targetSizeBytes * 0.9).toInt()
    val upperBound = (targetSizeBytes * 1.1).toInt()

    // Check if the image is already smaller than the lower bound
    if (byteArray.size <= upperBound) {
        return byteArray
    }

    var low = 0.0
    var high = 1.0


    while (low <= high) {
        val mid = (low + high) / 2
        val data = when (format.lowercase()) {
            "jpeg", "jpg" -> UIImageJPEGRepresentation(uiImage, mid)!!
            "png" -> UIImagePNGRepresentation(uiImage)!!
            else -> throw IllegalArgumentException("Unsupported format: $format")
        }
        val compressedByteArray = data.bytes!!.readBytes(data.length.toInt())
        if (compressedByteArray.size in lowerBound..upperBound) {
            return compressedByteArray
        } else if (compressedByteArray.size < lowerBound) {
            low = mid + 0.01
        } else {
            high = mid - 0.01
        }
    }
    return byteArray
}