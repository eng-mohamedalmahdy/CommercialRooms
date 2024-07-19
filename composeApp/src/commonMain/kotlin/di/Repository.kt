package di

import data.DummyAppInfoRepository
import domain.repository.AppInfoRepository
import org.koin.dsl.module


val repositoryModule = module {
    single<AppInfoRepository> { DummyAppInfoRepository() }
}