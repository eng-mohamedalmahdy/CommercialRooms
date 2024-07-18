package ui.config

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.config.AppTab.ABOUT_US
import ui.config.AppTab.CONTACT_US
import ui.config.AppTab.HOME
import ui.config.AppTab.LANGUAGE
import ui.config.AppTab.MORE

interface AppTabs {
    val entries: List<AppTab>
}

object DefaultTabs : AppTabs {
    override val entries: List<AppTab>
        get() = listOf(
            HOME,
            ABOUT_US,
            CONTACT_US,
            LANGUAGE,
            MORE
        )
}

enum class AppTab {
    HOME, ABOUT_US, CONTACT_US, LANGUAGE, MORE
}

@Composable
fun AppTab.icon(): Any = when (this) {
    HOME -> AppIcons.homeIcon
    ABOUT_US -> AppIcons.aboutUs
    CONTACT_US -> AppIcons.contactUs
    LANGUAGE -> AppIcons.language
    MORE -> AppIcons.more
}

@Composable
fun AppTab.localisedName(): String = when (this) {
    HOME -> stringResource(MR.strings.home)
    ABOUT_US -> stringResource(MR.strings.about_us)
    CONTACT_US -> stringResource(MR.strings.contact)
    LANGUAGE -> stringResource(MR.strings.language)
    MORE -> stringResource(MR.strings.more)
}

fun AppTab.screen(isUserSignedIn: Boolean): Screen? = null

