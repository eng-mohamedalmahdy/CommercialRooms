package framework


object ImageUtil {
    suspend fun compressImage(byteArray: ByteArray, format: String, quality: Double): ByteArray {
        return platformCompressImage(byteArray, format, quality)
    }

    suspend fun compressImageToSize(byteArray: ByteArray, format: String, targetSizeKb: Int): ByteArray {
        return platformCompressImageToSize(byteArray, format, targetSizeKb)
    }
}

expect suspend fun platformCompressImage(byteArray: ByteArray, format: String, quality: Double): ByteArray

expect suspend fun platformCompressImageToSize(byteArray: ByteArray, format: String, targetSizeKb: Int): ByteArray
