package ui.entity

import dev.icerock.moko.resources.desc.ResourceFormattedStringDesc

actual fun ResourceFormattedStringDesc.formattedString(): String {
    return this.localized()
}