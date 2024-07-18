package domain.usecase

import domain.repository.AppInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for AppInfoRepository
 */
class GetAboutAppUseCase(private val repository: AppInfoRepository) {

    suspend operator fun invoke() = repository.getAboutUs()
}
