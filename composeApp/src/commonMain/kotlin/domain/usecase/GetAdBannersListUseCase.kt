package domain.usecase

import domain.repository.AppInfoRepository

/**
 * Use case for getAdBannersList
 */
class GetAdBannersListUseCase(private val repository: AppInfoRepository) {

    suspend operator fun invoke() = repository.getAdBannersList()
}
