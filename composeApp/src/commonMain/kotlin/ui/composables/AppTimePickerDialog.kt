package ui.composables

import androidx.compose.foundation.background
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class, FormatStringsInDatetimeFormats::class)
@Composable
fun AppTimePickerDialog(
    title: String,
    onDismiss: () -> Unit,
    onTimeSelected: (Long?, String?) -> Unit,
    modifier: Modifier = Modifier,
    timeFormat: String = "HH:mm",
) {
    val timePickerState = rememberTimePickerState()
    val dateTimeFormatter by remember { mutableStateOf(LocalTime.Format { byUnicodePattern(timeFormat) }) }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.background,
        titleContentColor = MaterialTheme.colorScheme.primary,
        confirmButton = {
            Button(onClick = {
                val timeInMillis = timePickerState.hour * 3600000L + timePickerState.minute * 60000L
                val asInstant = Instant.fromEpochMilliseconds(timeInMillis)
                val formattedTime = asInstant.toLocalDateTime(TimeZone.UTC).time
                onTimeSelected(timeInMillis, dateTimeFormatter.format(formattedTime))

            }) {
                Text(
                    stringResource(MR.strings.confirm),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text(
                    stringResource(MR.strings.cancel),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        title = {
            Text(
                title,
                style = MaterialTheme.typography.headlineMedium,
            )
        },
        text = {
            TimePicker(
                state = timePickerState,
                colors = TimePickerDefaults.colors(
                    periodSelectorBorderColor = MaterialTheme.colorScheme.primary,
                    periodSelectorSelectedContainerColor = MaterialTheme.colorScheme.primary,
                    periodSelectorUnselectedContainerColor = MaterialTheme.colorScheme.background,
                    periodSelectorSelectedContentColor = MaterialTheme.colorScheme.onPrimary,
                    periodSelectorUnselectedContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                modifier = modifier.background(
                    MaterialTheme.colorScheme.background.copy(alpha = 1f),
                    DatePickerDefaults.shape
                ),
            )
        }
    )
}