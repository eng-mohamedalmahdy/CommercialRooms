package ui.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.svg.SvgDecoder
import dev.icerock.moko.resources.desc.StringDesc
import di.multithreadingModule
import di.repositoryModule
import di.settingsModule
import di.useCaseModule
import di.viewModelModule
import domain.entity.DomainAppLanguage
import domain.entity.error.DomainError
import domain.entity.error.DomainNetworkError
import framework.PushNotificationsKit
import io.github.aakira.napier.Napier
import kotlinx.coroutines.launch
import org.koin.compose.KoinApplication
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.context.loadKoinModules
import org.koin.mp.KoinPlatform
import ui.config.AppTheme
import ui.error.asUiText
import ui.navigation.SnackBarAction
import ui.navigation.asSnakeBarAction
import ui.navigation.color
import ui.pages.navhostpage.VoyagerNavigationHostPage


@OptIn(ExperimentalCoilApi::class)
@Composable
fun App() {
    val coroutineScope = rememberCoroutineScope()
    setSingletonImageLoaderFactory {
        ImageLoader.Builder(it)
            .components {
                add(SvgDecoder.Factory())
            }

            .build()
    }


    PushNotificationsKit.initNotificationListener(coroutineScope)


    KoinContext(
        KoinPlatform.getKoin().apply {
            loadKoinModules(
                listOf(
                    repositoryModule,
                    useCaseModule,
                    multithreadingModule,
                    viewModelModule,
                    settingsModule
                )
            )
        }
    ) {
        val mainViewModel = koinViewModel<MainViewModel>()
        val language by mainViewModel.currentLanguageFlow.collectAsState()
        StringDesc.localeType = StringDesc.LocaleType.Custom(DomainAppLanguage.default.code)
        LaunchedEffect(language) {
            StringDesc.localeType = StringDesc.LocaleType.Custom(DomainAppLanguage.default.code)
        }

        val snackBarHostState = remember { SnackbarHostState() }

        CompositionLocalProvider(
            LocalSnackBarHostState provides snackBarHostState,
            LocalMainViewModel provides mainViewModel,
            LocalLayoutDirection provides if (language == DomainAppLanguage.arabic) LayoutDirection.Rtl else LayoutDirection.Ltr
        ) {
            AppTheme {
                Scaffold(
                    snackbarHost = {
                        SnackbarHost(
                            snackBarHostState,
                            Modifier.padding(16.dp)
                        ) {
                            val action = it.visuals.actionLabel?.asSnakeBarAction()
                            val snackColor = action?.color
                            Snackbar(
                                containerColor = snackColor
                                    ?: MaterialTheme.colorScheme.onBackground
                            ) {
                                Text(
                                    it.visuals.message,
                                    modifier = Modifier.padding(8.dp),
                                    color = MaterialTheme.colorScheme.background,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    },
                ) {
                    Navigator(VoyagerNavigationHostPage())
                }
            }
        }
    }
}

@Composable
fun HandleAppIntent(intent: AppIntent) {
    val viewModelStore = LocalViewModelStoreOwner.current?.viewModelStore
    when (intent) {
        is AppIntent.SessionExpired -> {
            val navigator = LocalNavigator.currentOrThrow
            navigator.popAll()
            viewModelStore?.clear()
//            navigator.navigateToSplash()
        }

        else -> {}
    }

}

@Composable
fun InvalidateSession() {
    val mainViewModel = LocalMainViewModel.current
    mainViewModel.submitIntent(AppIntent.NotifySessionExpired)
}

@Composable
fun HandleErrorIntent(error: DomainError) {
    val snackBarHostState = LocalSnackBarHostState.current
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        snackBarHostState.showSnackbar(
            message = error.asUiText().asString(),
            actionLabel = SnackBarAction.Error(),
            duration = SnackbarDuration.Short
        )
    }
    when (error) {
        DomainNetworkError.Unauthorized -> InvalidateSession()
        else -> {}
    }

}


val LocalSnackBarHostState = compositionLocalOf<SnackbarHostState> {
    error("No Host Provided")
}
val LocalMainViewModel = compositionLocalOf<MainViewModel> {
    error("No MainViewModel Provided")
}