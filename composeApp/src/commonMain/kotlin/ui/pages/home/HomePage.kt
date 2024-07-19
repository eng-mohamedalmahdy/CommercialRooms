package ui.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AdBanner
import ui.composables.AppTopBar
import ui.composables.PagerWithIndicatorAndTitle
import ui.composables.SignUpSuggestionCard
import ui.pages.signin.SignInPageScreen

@Composable
fun HomePage() {
    val navigator = LocalNavigator.currentOrThrow
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        AppTopBar(
            leadingTitle = stringResource(MR.strings.welcome_back_user, "User")
        )
        Spacer(Modifier.height(16.dp))
        AdBanner(null, stringResource(MR.strings.ad_here))
        SignUpSuggestionCard {
            navigator.push(SignInPageScreen)
        }
        Spacer(Modifier.height(16.dp))

        PagerWithIndicatorAndTitle(
            title = "News",
            items = List(10) { Any() },
            onItemClick = {}
        )
        Spacer(Modifier.height(16.dp))
        PagerWithIndicatorAndTitle(
            title = "News",
            items = List(10) { Any() },
            onItemClick = {}
        )
        Spacer(Modifier.height(16.dp))
        PagerWithIndicatorAndTitle(
            title = "News",
            items = List(10) { Any() },
            onItemClick = {}
        )
        Spacer(Modifier.height(150.dp))
    }
}

object HomePageScreen : Screen {

    @Composable
    override fun Content() = HomePage()

}