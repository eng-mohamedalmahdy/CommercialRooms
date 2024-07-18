package ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun UserProfileCard(userName: String, userQrImage: Any, modifier: Modifier = Modifier, onQrClick: () -> Unit) {
    Card(
        modifier = modifier.fillMaxWidth().padding(16.dp)
            .height(72.dp)
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary),
                shape = RoundedCornerShape(8.dp)
            ),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(MR.strings.welcome_back_user, userName),
                modifier = Modifier.padding(12.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.weight(1f))
            AppImage(
                userQrImage,
                modifier = Modifier
                    .padding(end = 26.dp)
                    .size(48.dp)
                    .clickable(
                        onClick = onQrClick,
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(bounded = false),
                        role = Role.Image
                    ),
                contentDescription = userName,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}