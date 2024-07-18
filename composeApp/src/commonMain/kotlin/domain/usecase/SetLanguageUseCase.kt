package domain.usecase

import domain.entity.DomainAppLanguage
import domain.repository.AppInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case for MiscRepository
 */
class SetLanguageUseCase(private val repository: AppInfoRepository) {

    suspend operator fun invoke(language: DomainAppLanguage) = repository.setLanguage(language)
}
