package ui.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ui.config.Colors

sealed class SnackBarAction(val name: String) {
    operator fun invoke() = name

    data object Success : SnackBarAction("success")

    data object Error : SnackBarAction("error")

    data object Info : SnackBarAction("info")
}

val SnackBarAction.color: Color
    @Composable get() = when (this) {
        SnackBarAction.Error -> MaterialTheme.colorScheme.error
        SnackBarAction.Info -> MaterialTheme.colorScheme.onBackground
        SnackBarAction.Success -> Colors.success
    }

fun String.asSnakeBarAction(): SnackBarAction? = when (this) {
    SnackBarAction.Success() -> SnackBarAction.Success
    SnackBarAction.Error() -> SnackBarAction.Error
    SnackBarAction.Info() -> SnackBarAction.Info
    else -> null
}