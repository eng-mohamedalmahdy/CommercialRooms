package di

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ui.app.MainViewModel

val viewModelModule = module {
    viewModelOf(::MainViewModel)

}