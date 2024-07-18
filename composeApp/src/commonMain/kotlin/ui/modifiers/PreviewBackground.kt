package ui.modifiers

import androidx.compose.foundation.background
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalInspectionMode

fun Modifier.previewBackground(color: Color,shape: Shape = RectangleShape): Modifier =
    composed {
        if (LocalInspectionMode.current) {
            then(background(color = color,shape))
        } else {
           then(background(color = Color.Transparent))
        }
    }