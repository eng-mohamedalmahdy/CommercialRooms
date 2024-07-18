package ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lightfeather.commercialrooms.MR
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format

import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.datetime.Clock


@OptIn(ExperimentalMaterial3Api::class, FormatStringsInDatetimeFormats::class)
@Composable
fun AppDatePickerDialog(
    title: String,
    onDismiss: () -> Unit,
    onDateSelected: (Long?, String?) -> Unit,
    modifier: Modifier = Modifier,
    selectableDates: SelectableDates = DatePickerDefaults.AllDates,
    dateFormat: String = "dd-MM-yyyy",
) {
    val datePickerState = rememberDatePickerState(
        selectableDates = selectableDates,
        initialSelectedDateMillis = Clock.System.now().toEpochMilliseconds()
    )

    val dateTimeFormatter by remember { mutableStateOf(LocalDateTime.Format { byUnicodePattern(dateFormat) }) }

    DatePickerDialog(
        onDismissRequest = onDismiss,
        colors = DatePickerDefaults.colors(
            titleContentColor = MaterialTheme.colorScheme.primary,
            headlineContentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.background,
        ),
        confirmButton = {
            Button(onClick = {
                val dateInMillis = datePickerState.selectedDateMillis
                val asInstant = dateInMillis?.let { Instant.fromEpochMilliseconds(it) }
                val asLocalDateTime = asInstant?.toLocalDateTime(TimeZone.currentSystemDefault())
                val formattedDate = asLocalDateTime?.format(dateTimeFormatter).toString()
                onDateSelected(datePickerState.selectedDateMillis, formattedDate)
            }) {

                Text(stringResource(MR.strings.confirm))
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text(stringResource(MR.strings.cancel))
            }
        },
        content = {
            DatePicker(
                state = datePickerState,
                modifier = modifier.background(
                    MaterialTheme.colorScheme.background.copy(alpha = 1f),
                    DatePickerDefaults.shape
                ),
                title = {
                    Text(
                        title,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(16.dp)
                    )
                },
                colors = DatePickerDefaults.colors(
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    headlineContentColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.background,
                ),
                showModeToggle = false
            )
        }
    )
}
