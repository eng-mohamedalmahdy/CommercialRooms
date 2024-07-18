package domain.usecase

import domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for signIn
 */
class SignInUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(userName: String, password: String) = repository.signIn(userName, password)
}
