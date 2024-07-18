package domain.entity

data class DomainAppointment(
    val fullName: String,
    val email: String,
    val phone: String,
    val fromDate: String,
    val toDate: String,
)
