package di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import domain.entity.DomainAppLanguage
import org.koin.core.qualifier.named
import org.koin.dsl.module

val settingsModule = module {
    factory<Settings> { Settings() }
    factory<DomainAppLanguage> { DomainAppLanguage.arabic }
    factory<String>(named(DIConstants.TOKEN)) {
        get<Settings>().getString(
            DIConstants.TOKEN.name,
            ""
        )
    }
}