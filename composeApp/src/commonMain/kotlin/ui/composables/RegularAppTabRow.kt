package ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.pages.services.AppServices

@Composable
fun <T> RegularAppTabRow(
    items: List<T>,
    labels: List<String>,
    selectedItem: T,
    onTabClick: (T) -> Unit
) {
    TabRow(
        items.indexOf(selectedItem),
        containerColor = MaterialTheme.colorScheme.background,
        indicator = {},
        divider = {}
    ) {
        items.forEachIndexed { idx, item ->
            Tab(
                selectedItem == item,
                onClick = { onTabClick(item) },
                modifier = Modifier.height(50.dp).background(
                    if (selectedItem == item) MaterialTheme.colorScheme.primary.copy(
                        alpha = 0.25f
                    ) else MaterialTheme.colorScheme.background,
                    RoundedCornerShape(16.dp)
                )
            ) {
                Text(labels[idx])
            }
        }
    }
}