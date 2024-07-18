package domain.entity

data class DomainPublishable(
    val id: String,
    val nameEn: String,
    val nameAr: String,
    val bodyEn: String,
    val bodyAr: String,
    val image: Any?
)
