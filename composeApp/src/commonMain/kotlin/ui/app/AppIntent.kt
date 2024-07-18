package ui.app

sealed interface AppIntent {
    data object Init : AppIntent

    data object NotifySessionExpired : AppIntent
    data object SessionExpired : AppIntent
}