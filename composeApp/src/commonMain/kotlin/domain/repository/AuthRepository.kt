package domain.repository

import domain.entity.DomainResponse
import domain.entity.DomainUser

interface AuthRepository {
    suspend fun signIn(userName: String, password: String): DomainResponse<String>

    suspend fun signUp(user: DomainUser, password: String): DomainResponse<String>

    suspend fun getCurrentUser(): DomainResponse<DomainUser>

}