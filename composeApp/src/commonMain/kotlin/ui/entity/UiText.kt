package ui.entity

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.compose.stringResource
import dev.icerock.moko.resources.desc.ResourceFormattedStringDesc
import dev.icerock.moko.resources.format

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    class StringResource(
        val id: dev.icerock.moko.resources.StringResource,
        val args: Array<Any> = arrayOf()
    ) : UiText()

    @Composable
    fun asComposableString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(id, *args)
        }
    }

    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> id.format(args).formattedString()
        }
    }
}

expect fun ResourceFormattedStringDesc.formattedString(): String