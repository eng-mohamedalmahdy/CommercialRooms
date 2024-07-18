package ui.pages.navhostpage

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Selected
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.core.stack.Stack
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.internal.BackHandler
import di.DIConstants
import framework.exitApp
import io.github.aakira.napier.Napier
import kotlinx.serialization.json.JsonNull.content
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.qualifier.named
import ui.app.AppIntent
import ui.app.HandleAppIntent
import ui.app.LocalMainViewModel
import ui.app.MainViewModel
import ui.composables.BottomNavigationBar
import ui.composables.SessionExpiredDialog
import ui.config.AppTab
import ui.config.AppTabs
import ui.config.DefaultTabs
import ui.config.screen

@OptIn(InternalVoyagerApi::class)
@Composable
fun NavigationHostPage() {
    val token = koinInject<String>(named(DIConstants.TOKEN))
    val tabs = DefaultTabs
    val isUserSignedIn = token.isNotEmpty()
    var isShowingSessionExpiredDialog by remember { mutableStateOf(false) }
    val mainViewModel = LocalMainViewModel.current
    val appIntent by mainViewModel.intentsFlow.collectAsState()
    val tabsStack by mainViewModel.tabsStack.collectAsState()
    var localNavigator = LocalNavigator.currentOrThrow
    BackHandler(true) {
        if (tabsStack.size > 1) {
            mainViewModel.popFromTabStack()
        } else {
            exitApp()
        }
    }

    LaunchedEffect(appIntent) {
        when (appIntent) {
            is AppIntent.NotifySessionExpired -> isShowingSessionExpiredDialog = true
            else -> {}
        }
    }


    HandleAppIntent(appIntent)

    Box {
        if (isShowingSessionExpiredDialog) {
            SessionExpiredDialog(
                onDismiss = {
                    isShowingSessionExpiredDialog = false
                    mainViewModel.submitIntent(AppIntent.SessionExpired)
                }
            )
        }
        NavigationHostPageStateless(
            tabs = tabs,
            selectedTab = tabsStack.lastOrNull(),
            onTabSelected = { tab ->
                if (tabsStack.lastOrNull() == tab) {
                    localNavigator.popUntilRoot()
                } else {
                    mainViewModel.pushToTabStack(tab)
                }
            }
        ) {

            AnimatedContent(tabsStack.lastOrNull()) {
                tabsStack.last().screen(isUserSignedIn)?.let { it1 ->
                    Navigator(it1) {
                        localNavigator = it
                        CurrentScreen()
                    }
                }
            }
        }
    }

}

@Composable
private fun NavigationHostPageStateless(
    tabs: AppTabs,
    selectedTab: AppTab?,
    onTabSelected: (AppTab) -> Unit,
    content: @Composable () -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        content()
        BottomNavigationBar(tabs, selectedTab, modifier = Modifier.align(Alignment.BottomCenter), onTabSelected)
    }

}

@Preview
@Composable
private fun PreviewNavigationHostPage() {
    // Preview composable
    NavigationHostPageStateless(
        tabs = DefaultTabs,
        selectedTab = AppTab.HOME,
        onTabSelected = {},
        content = {}
    )
}
