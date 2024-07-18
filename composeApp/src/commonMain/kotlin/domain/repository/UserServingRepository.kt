package domain.repository

import domain.entity.DomainAppointment
import domain.entity.DomainFeedbackForm
import domain.entity.DomainResponse
import domain.entity.DomainService

interface UserServingRepository {

    suspend fun getDigitalServicesList(): DomainResponse<List<DomainService>>

    suspend fun getPublicServicesList(): DomainResponse<List<DomainService>>

    suspend fun submitFeedback(feedback: DomainFeedbackForm): DomainResponse<String>

    suspend fun submitContactForm(feedback: DomainFeedbackForm): DomainResponse<String>

    suspend fun bookAppointment(appointment: DomainAppointment): DomainResponse<String>

}