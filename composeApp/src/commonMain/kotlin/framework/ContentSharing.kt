package framework

expect object ShareKit {
    suspend fun shareImage(image: String): Unit

    fun shareText(text: String): Unit
}
