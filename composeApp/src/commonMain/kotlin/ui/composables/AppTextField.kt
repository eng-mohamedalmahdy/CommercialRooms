package ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: Any? = null,
    trailingIcon: Any? = null,
    onTrailingClick: (() -> Unit)? = null,
    keyboardType: KeyboardType? = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    error: String? = null,
    errorEnabled: Boolean = false,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors().copy(
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType ?: KeyboardType.Text, imeAction = imeAction),
        visualTransformation = if (keyboardType != KeyboardType.Password) VisualTransformation.None else PasswordVisualTransformation(),
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = leadingIcon?.let {
            {
                AppImage(
                    it,
                    Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary),
                    contentScale = ContentScale.FillBounds
                )
            }
        },
        trailingIcon = trailingIcon?.let {
            {
                AppImage(
                    it, Modifier.size(24.dp).clickable(onClick = { onTrailingClick?.invoke() }),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                    contentScale = ContentScale.FillBounds

                )
            }
        },
        placeholder = {
            Text(
                label,
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.secondary)
            )
        },
        shape = RoundedCornerShape(8.dp),
        singleLine = singleLine,
        enabled = keyboardType != null,
        readOnly = keyboardType == null,
        keyboardActions = keyboardActions,
        isError = errorEnabled,
        supportingText = {
            error?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.error)
                )
            }
        },

    )

}