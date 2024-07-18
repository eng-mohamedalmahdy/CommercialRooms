package domain.entity

data class DomainFeedbackForm(
    val fullName: String,
    val email: String,
    val feedback: String,
    val phone: String?
)
