package domain.repository

import domain.entity.DomainAppLanguage
import domain.entity.DomainResponse
import domain.entity.DomainPublishable

interface AppInfoRepository {

    suspend fun getAdBannersList(): DomainResponse<List<Any>>

    suspend fun getPublishablesOfType(type: String): DomainResponse<List<DomainPublishable>>

    suspend fun getAboutUs(): DomainResponse<String>

    suspend fun getSupervisorsWord(): DomainResponse<String>

    suspend fun getAppVision(): DomainResponse<String>

    suspend fun setLanguage(language: DomainAppLanguage): DomainResponse<Unit>

}