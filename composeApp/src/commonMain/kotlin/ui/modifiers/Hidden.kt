package ui.modifiers

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

fun Modifier.hidden(): Modifier = then(alpha(0f))

