package ui.config

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.config.AppTab.ABOUT_US
import ui.config.AppTab.HOME
import ui.config.AppTab.MORE
import ui.config.AppTab.NEWS
import ui.config.AppTab.SERVICES
import ui.pages.aboutus.AboutUsPageScreen
import ui.pages.home.HomePageScreen
import ui.pages.more.MorePageScreen
import ui.pages.news.NewsPageScreen
import ui.pages.services.ServicesPageScreen

interface AppTabs {
    val entries: List<AppTab>
}

object DefaultTabs : AppTabs {
    override val entries: List<AppTab>
        get() = listOf(
            HOME,
            SERVICES,
            NEWS,
            ABOUT_US,
            MORE
        )
}

enum class AppTab {
    HOME, ABOUT_US, MORE, SERVICES, NEWS
}

@Composable
fun AppTab.icon(): Any = when (this) {
    HOME -> AppIcons.homeIcon
    SERVICES -> AppIcons.services
    ABOUT_US -> AppIcons.aboutUs
    MORE -> AppIcons.more
    NEWS -> AppIcons.camera
}

@Composable
fun AppTab.localisedName(): String = when (this) {
    HOME -> stringResource(MR.strings.home)
    ABOUT_US -> stringResource(MR.strings.about_us)
    NEWS -> stringResource(MR.strings.about_us)
    MORE -> stringResource(MR.strings.more)
    SERVICES -> stringResource(MR.strings.services)
}

fun AppTab.screen(isUserSignedIn: Boolean): Screen =
    when (this) {
        HOME -> HomePageScreen
        SERVICES -> ServicesPageScreen
        NEWS -> NewsPageScreen
        ABOUT_US -> AboutUsPageScreen
        MORE -> MorePageScreen
    }

