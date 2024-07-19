package ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun <T> CircleIndicatorAppTabRow(
    items: List<T>,
    labels: List<String>,
    selectedItem: T,
    onTabClick: (T) -> Unit
) {
    TabRow(
        items.indexOf(selectedItem),
        containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
        indicator = {

        }
    ) {
        items.forEachIndexed { idx, item ->
            Tab(
                selectedItem == item,
                onClick = { onTabClick(item) },
                modifier = Modifier.height(50.dp),

                ) {
                Column(
                    modifier = Modifier.padding(vertical = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val color =
                        if (selectedItem == item) MaterialTheme.colorScheme.primary else Color.Transparent

                    Text(
                        labels[idx],
                        color = if (selectedItem == item) MaterialTheme.colorScheme.primary else Color.Black
                    )
                    Spacer(Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(8.dp)
                            .background(color, CircleShape)
                    )
                }
            }
        }
    }
}