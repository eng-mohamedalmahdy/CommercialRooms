package ui.entity

import domain.entity.DomainUser

data class UiUser(
    val id: String,
    val registrationFields: Map<String, String>,
)

