package framework

interface ContactPicker {
    suspend fun pickContact(): Contact?
}

data class Contact(
    val name: String,
    val phoneNumber: String,
    val email: String?,
)
