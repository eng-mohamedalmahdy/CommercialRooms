package ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import domain.entity.DomainAppLanguage
import ui.config.AppIcons.language

@Composable
fun LanguageRow(
    language: DomainAppLanguage,
    isSelected: Boolean,
    onCLick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 14.dp, end = 24.dp)
            .padding(vertical = 4.dp)
            .height(48.dp)
            .clickable(onClick = onCLick),
        elevation = CardDefaults.cardElevation(0.dp),
        border = if (isSelected) BorderStroke(1.dp, MaterialTheme.colorScheme.secondary) else null,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            Modifier.fillMaxSize().padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                language.name,
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.weight(1f))
            AppImage(
                language.flag,
                modifier = Modifier.clip(CircleShape).size(16.dp).clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )
            Spacer(Modifier.width(24.dp))
        }
    }
}