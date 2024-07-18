package ui.modifiers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.clickableRipple(color: Color? = null, radius: Dp? = 2.dp, onClick: () -> Unit): Modifier =
    composed {
        then(clickable(
            onClick = onClick,
            indication = rememberRipple(
                bounded = false,
                radius = radius ?: Dp.Unspecified,
                color = color ?: Color.Unspecified
            ),
            interactionSource = remember {
                MutableInteractionSource()
            }
        ))
    }
