package ui.error

import com.lightfeather.commercialrooms.MR
import domain.entity.error.DomainError
import domain.entity.error.DomainInternalError
import domain.entity.error.DomainNetworkError
import ui.entity.UiText

fun DomainError.asUiText(): UiText = when (this) {
    DomainNetworkError.Unauthorized -> UiText.StringResource(MR.strings.invalid_credentials)
    is DomainInternalError.Validation -> UiText.DynamicString(fields.joinToString("\n"))
    else -> UiText.StringResource(MR.strings.unknown_error)


}