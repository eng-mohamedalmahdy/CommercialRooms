package domain.entity

data class DomainUser(
    val id: String,
    val fullName: String,
    val email: String,
    val phone: String,
    val nationalId: String
)
