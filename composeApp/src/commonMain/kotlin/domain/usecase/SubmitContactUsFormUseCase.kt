package domain.usecase

import domain.entity.DomainFeedbackForm
import domain.repository.UserServingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for submitContactForm
 */
class SubmitContactUsFormUseCase(private val repository: UserServingRepository) {

    suspend operator fun invoke(feedbackForm: DomainFeedbackForm) = repository.submitContactForm(feedbackForm)
}
