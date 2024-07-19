package ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ui.config.AppIcons

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    leadingTitle: String? = null,
    trailingComponent: @Composable (() -> Unit)? = null,
    onBackPress: (() -> Unit)? = null,
    onTrailingClick: (() -> Unit)? = null
) {
    val layoutDirection = LocalLayoutDirection.current
    Row(
        modifier.padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        onBackPress?.let {
            Icon(
                AppIcons.ArrowBack,
                contentDescription = null,
                modifier = Modifier.clickable(
                    onClick = it,
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(false),
                    role = Role.Button
                ).scale(scaleX = if (layoutDirection == androidx.compose.ui.unit.LayoutDirection.Rtl) -1f else 1f, scaleY = 1f),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        leadingTitle?.let {
            Text(
                it,
                Modifier.padding(horizontal = if (onBackPress != null) 32.dp else 0.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
        trailingComponent?.let {
            Spacer(Modifier.weight(1f))

            Box(
                Modifier.clickable(
                    onClick = { onTrailingClick?.invoke() },
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(false),
                    role = Role.Button
                )
            ) {
                it()
            }
        }
    }
}