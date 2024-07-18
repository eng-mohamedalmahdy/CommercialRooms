package di

import framework.BackgroundProcessManager
import framework.entity.BackgroundProcess
import framework.provideBackgroundProcessManager
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.named
import org.koin.dsl.module

val multithreadingModule = module {
    factory { SupervisorJob() }
    factory { CoroutineScope(Dispatchers.IO + get<CompletableJob>()) }
    single<BackgroundProcessManager> { provideBackgroundProcessManager() }
    single(named("IODispatcher")) { Dispatchers.IO }
}