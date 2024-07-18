package domain.entity

import domain.entity.error.DomainError

sealed class DomainResponse<out T> {
    data class Success<T>(val data: T) : DomainResponse<T>()
    data class Failure(val error: DomainError) : DomainResponse<Nothing>()
}

suspend fun <T> runCatchingWithDomainResponseAsResult(
    onError: (Throwable) -> DomainError = { DomainError.DefaultError },
    block: suspend () -> T
): DomainResponse<T> = runCatching {
    DomainResponse.Success(block())
}.getOrElse {
    val error = onError(it)
    DomainResponse.Failure(error)
}

fun <T> DomainResponse<T>.successOrElse(block: () -> T) = when (this) {
    is DomainResponse.Success -> this.data
    else -> block()


}