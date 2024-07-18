package data

import domain.entity.DomainAppLanguage
import domain.entity.DomainPublishable
import domain.entity.DomainResponse
import domain.repository.AppInfoRepository

class DummyAppInfoRepository : AppInfoRepository {

    override suspend fun getAdBannersList(): DomainResponse<List<Any>> {
        val dummyBanners = listOf("Banner1", "Banner2", "Banner3")
        return DomainResponse.Success(dummyBanners)
    }

    override suspend fun getPublishablesOfType(type: String): DomainResponse<List<DomainPublishable>> {
        val dummyPublishables = listOf(
            DomainPublishable("1", "Title1En", "Title1Ar", "Body1En", "Body1Ar", null),
            DomainPublishable("2", "Title2En", "Title2Ar", "Body2En", "Body2Ar", null)
        )
        return DomainResponse.Success(dummyPublishables)
    }

    override suspend fun getAboutUs(): DomainResponse<String> {
        return DomainResponse.Success("About Us information")
    }

    override suspend fun getSupervisorsWord(): DomainResponse<String> {
        return DomainResponse.Success("Supervisor's Word")
    }

    override suspend fun getAppVision(): DomainResponse<String> {
        return DomainResponse.Success("App Vision")
    }

    override suspend fun setLanguage(language: DomainAppLanguage): DomainResponse<Unit> {
        return DomainResponse.Success(Unit)
    }
}
