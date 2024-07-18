package domain.entity.error

sealed interface DomainError {

    val code: Int

    data object DefaultError : DomainError {
        override val code: Int
            get() = 0
    }

}