package data

import domain.entity.DomainAppointment
import domain.entity.DomainFeedbackForm
import domain.entity.DomainResponse
import domain.entity.DomainService
import domain.repository.UserServingRepository

class DummyUserServingRepository : UserServingRepository {

    override suspend fun getDigitalServicesList(): DomainResponse<List<DomainService>> {
        val dummyServices = listOf(
            DomainService("1", "Digital Service 1En", "Digital Service 1Ar", "Body 1En", "Body 1Ar", null),
            DomainService("2", "Digital Service 2En", "Digital Service 2Ar", "Body 2En", "Body 2Ar", null)
        )
        return DomainResponse.Success(dummyServices)
    }

    override suspend fun getPublicServicesList(): DomainResponse<List<DomainService>> {
        val dummyServices = listOf(
            DomainService("3", "Public Service 1En", "Public Service 1Ar", "Body 1En", "Body 1Ar", null),
            DomainService("4", "Public Service 2En", "Public Service 2Ar", "Body 2En", "Body 2Ar", null)
        )
        return DomainResponse.Success(dummyServices)
    }

    override suspend fun submitFeedback(feedback: DomainFeedbackForm): DomainResponse<String> {
        return DomainResponse.Success("Feedback submitted successfully")
    }

    override suspend fun submitContactForm(feedback: DomainFeedbackForm): DomainResponse<String> {
        return DomainResponse.Success("Contact form submitted successfully")
    }

    override suspend fun bookAppointment(appointment: DomainAppointment): DomainResponse<String> {
        return DomainResponse.Success("Appointment booked successfully")
    }
}
