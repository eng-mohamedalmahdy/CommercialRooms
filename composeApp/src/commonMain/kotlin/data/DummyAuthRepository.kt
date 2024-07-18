package data

import domain.entity.DomainResponse
import domain.entity.DomainUser
import domain.entity.error.DomainError
import domain.repository.AuthRepository

class DummyAuthRepository : AuthRepository {

    override suspend fun signIn(userName: String, password: String): DomainResponse<String> {
        return if (userName == "test" && password == "password") {
            DomainResponse.Success("Login successful")
        } else {
            DomainResponse.Failure(DomainError.DefaultError)
        }
    }

    override suspend fun signUp(user: DomainUser, password: String): DomainResponse<String> {
        return DomainResponse.Success("Sign up successful for user: ${user.fullName}")
    }

    override suspend fun getCurrentUser(): DomainResponse<DomainUser> {
        val dummyUser = DomainUser("1", "John Doe", "john.doe@example.com", "1234567890", "NID12345")
        return DomainResponse.Success(dummyUser)
    }
}
