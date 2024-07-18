package domain.usecase

import domain.repository.AppInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for getPublishablesOfType
 */
class GetPublishableListOfTypeUseCase(private val repository: AppInfoRepository) {

    suspend operator fun invoke(type: String) = repository.getPublishablesOfType(type)
}
