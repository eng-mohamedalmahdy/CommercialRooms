package domain.usecase

import domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for getCurrentUser
 */
class GetCurrentUserUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke() = repository.getCurrentUser()
}
