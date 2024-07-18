package ui.entity

import android.content.Context
import dev.icerock.moko.resources.desc.ResourceFormattedStringDesc
import org.koin.mp.KoinPlatform

actual fun ResourceFormattedStringDesc.formattedString(): String {
    val context = KoinPlatform.getKoin().get<Context>()
    return this.toString(context)
}