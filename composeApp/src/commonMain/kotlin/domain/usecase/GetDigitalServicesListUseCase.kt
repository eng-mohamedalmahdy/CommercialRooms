package domain.usecase

import domain.repository.UserServingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for getDigitalServicesList
 */
class GetDigitalServicesListUseCase(private val repository: UserServingRepository) {

    suspend operator fun invoke() = repository.getDigitalServicesList()
}
