package ui.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import di.DIConstants
import domain.entity.DomainAppLanguage
import domain.usecase.SetLanguageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform
import ui.config.AppTab

class MainViewModel(
    private val setLanguageUseCase: SetLanguageUseCase,
) : ViewModel() {

    private val currentLanguage = KoinPlatform.getKoin().get<DomainAppLanguage>()
    private val _currentLanguageFlow = MutableStateFlow(currentLanguage)
    val currentLanguageFlow = _currentLanguageFlow.asStateFlow()

    private val _intentsFlow = MutableStateFlow<AppIntent>(AppIntent.Init)
    val intentsFlow = _intentsFlow.asStateFlow()

    private val _tabsStack = MutableStateFlow(listOf<AppTab>(AppTab.HOME))
    val tabsStack = _tabsStack.asStateFlow()

    fun submitIntent(intent: AppIntent) {
        _intentsFlow.value = intent
    }

    fun setLanguage(language: DomainAppLanguage) = viewModelScope.launch {
        setLanguageUseCase(language)
        _currentLanguageFlow.value = language
    }

    fun pushToTabStack(tab: AppTab) {
        _tabsStack.value += tab
    }

    fun popFromTabStack() {
        _tabsStack.value = _tabsStack.value.dropLast(1)
    }
    fun popAll() {
        _tabsStack.value = emptyList()
    }
    fun popToTab(tab: AppTab) {
        _tabsStack.value = listOf(tab)
    }



}