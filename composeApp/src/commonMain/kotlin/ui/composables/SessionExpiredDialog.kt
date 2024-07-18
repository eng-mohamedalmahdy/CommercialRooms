package ui.composables

import androidx.compose.material.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun SessionExpiredDialog(onDismiss: () -> Unit) =
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = stringResource(MR.strings.session_expired))
        },
        text = {
            Text(stringResource(MR.strings.your_session_has_been_expired_message))
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    stringResource(MR.strings.confirm),
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        },
    )
