package di

import framework.DriverFactory
import framework.DriverFactoryIosImpl
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<DriverFactory> { DriverFactoryIosImpl() }
}