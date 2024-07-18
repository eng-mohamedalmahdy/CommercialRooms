package domain.usecase

import domain.repository.UserServingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for getPublicServicesList
 */
class GetPublicServicesUseCase(private val repository: UserServingRepository) {

    suspend operator fun invoke() = repository.getPublicServicesList()
}
