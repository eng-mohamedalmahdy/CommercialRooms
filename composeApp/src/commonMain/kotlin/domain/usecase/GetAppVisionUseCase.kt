package domain.usecase

import domain.repository.AppInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for getAppVision
 */
class GetAppVisionUseCase(private val repository: AppInfoRepository) {

    suspend operator fun invoke() = repository.getAppVision()
}
