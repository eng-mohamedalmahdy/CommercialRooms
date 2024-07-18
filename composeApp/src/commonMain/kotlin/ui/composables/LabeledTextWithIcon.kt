package ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabeledTextWithIcon(
    label: String,
    text: String,
    maxLabelWidth: MutableState<Int>,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    labelModifier: Modifier = Modifier,
    icon: Any? = null
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            modifier = textModifier
                .padding(end = 16.dp)
                .padding(vertical = 16.dp)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    maxLabelWidth.value = maxOf(maxLabelWidth.value, placeable.width)
                    layout(width = maxLabelWidth.value, height = placeable.height) {
                        placeable.placeRelative(0, 0)
                    }
                },
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Normal,
        )
        Card(
            modifier = labelModifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.weight(1f))
                icon?.let {
                    AppImage(
                        it,
                        modifier = Modifier.size(16.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                }
            }
        }
    }
}