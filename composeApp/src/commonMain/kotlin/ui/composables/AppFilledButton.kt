package ui.composables

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppFilledButton(
    text: String,
    modifier: Modifier = Modifier,
    fillColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    shape: Shape = RoundedCornerShape(8.dp),
    onClick: () -> Unit
) {
    Button(
        onClick, modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = fillColor,
            contentColor = contentColor,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = shape
    ) {
        Text(text, style = textStyle)
    }
}


@Preview
@Composable
private fun PreviewAppFilledButton() {

}