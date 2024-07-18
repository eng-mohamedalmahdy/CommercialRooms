package domain.usecase

import domain.entity.DomainUser
import domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for signUp
 */
class SignUpUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: DomainUser, password: String) = repository.signUp(user, password)
}
