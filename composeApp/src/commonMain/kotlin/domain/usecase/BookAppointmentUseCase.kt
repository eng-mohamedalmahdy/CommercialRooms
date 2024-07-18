package domain.usecase

import domain.entity.DomainAppointment
import domain.repository.UserServingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for bookAppointment
 */
class BookAppointmentUseCase(private val repository: UserServingRepository) {

    suspend operator fun invoke(appointment: DomainAppointment) = repository.bookAppointment(appointment)
}
