package domain.entity

data class DomainAppLanguage(
    val code: String,
    val name: String,
    val flag: Any
) {
    companion object {
        val english = DomainAppLanguage(
            code = "en",
            name = "English",
            flag = "https://flagcdn.com/w320/us.png"
        )
        val arabic = DomainAppLanguage(
            code = "ar",
            name = "العربية",
            flag = "https://flagcdn.com/w320/eg.png"
        )
        val default = arabic
    }
}