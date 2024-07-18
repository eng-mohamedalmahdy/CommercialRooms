package domain.entity.error

sealed interface DomainInternalError : DomainError {
    data object Unknown : DomainInternalError {
        override val code: Int = 700
    }

    data object Permission : DomainInternalError {
        override val code: Int = 701
    }

    data class Validation(val fields: List<String>) : DomainInternalError {
        override val code: Int = 702
    }

}