package domain.entity.error

interface DomainNetworkError : DomainError {

    data object Unauthorized : DomainNetworkError {
        override val code: Int
            get() = 401

    }

    data object Forbidden : DomainNetworkError {
        override val code: Int
            get() = 403
    }

    data object ParseException : DomainNetworkError {
        override val code: Int
            get() = 400
    }
}