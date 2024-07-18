package ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import domain.entity.Filterable


@Composable
fun <T : Filterable> FilterDialog(
    title:String,
    items: List<Pair<T, Int?>>,
    onDismiss: () -> Unit,
    onConfirmedSelected: (List<T>) -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedFilters: List<T> by remember { mutableStateOf(emptyList()) }
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.background,
        titleContentColor = MaterialTheme.colorScheme.primary,
        confirmButton = {
            Button(
                onClick = {
                    onConfirmedSelected(selectedFilters)
                    onDismiss()
                }
            ) {
                Text(
                    stringResource(MR.strings.confirm),
                    style = MaterialTheme.typography.bodyMedium

                )
            }
        },
        dismissButton = {
            OutlinedButton(onDismiss) {
                Text(
                    stringResource(MR.strings.cancel),
                    style = MaterialTheme.typography.bodyMedium

                )
            }
        },
        text = {
            Card(
                modifier.padding(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Column {
                    Text(title)
                    Spacer(Modifier.height(16.dp))
                    items.forEachIndexed { idx, filter ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val isSelected = filter.first in selectedFilters
                            Checkbox(
                                checked = isSelected,
                                onCheckedChange = {
                                    selectedFilters = if (isSelected) {
                                        selectedFilters - filter.first
                                    } else {
                                        selectedFilters + filter.first
                                    }

                                }
                            )
                            Text(filter.first.filterName)

                            Spacer(Modifier.weight(1f))

                            filter.second?.let {
                                Text(filter.second.toString())
                            }
                        }
                        if (idx < items.lastIndex) {
                            HorizontalDivider(Modifier.padding(horizontal = 12.dp))
                        }
                    }
                }

            }
        }
    )
}