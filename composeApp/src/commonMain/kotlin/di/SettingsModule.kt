package di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import domain.entity.DomainAppLanguage
import org.koin.core.qualifier.named
import org.koin.dsl.module

val settingsModule = module {
    factory<Settings> { Settings() }
    factory<DomainAppLanguage> {
        val langCode =
            get<Settings>().getString(DIConstants.LANG_CODE.name, DomainAppLanguage.default.code)
        when (langCode) {
            DomainAppLanguage.arabic.code -> DomainAppLanguage.arabic
            else -> DomainAppLanguage.default
        }
    }
    factory<String>(named(DIConstants.TOKEN)) {
        get<Settings>().getString(
            DIConstants.TOKEN.name,
            ""
        )
    }
}