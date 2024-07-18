package ui.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import commercialrooms.composeapp.generated.resources.Res
import commercialrooms.composeapp.generated.resources.ellipse
import org.jetbrains.compose.resources.painterResource
import ui.config.AppTab
import ui.config.AppTabs
import ui.config.icon
import ui.config.localisedName
import ui.modifiers.applyIf


@Composable
fun BottomNavigationBar(tabs: AppTabs, selectedTab: AppTab?, modifier: Modifier = Modifier, onItemSelected: (AppTab) -> Unit) {
    Box(modifier.height(80.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(64.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            elevation = CardDefaults.cardElevation(2.dp),
        ) {}

        Row(
            Modifier.fillMaxWidth().zIndex(1f).background(Color.Transparent),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.entries.forEach { item ->

                val isSelected = item == selectedTab
                val iconTint by animateColorAsState(if (isSelected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary)
                val indicatorSize by animateDpAsState(if (isSelected) 8.dp else 0.dp)
                val offsetY by animateDpAsState(if (isSelected) (-28).dp else 0.dp)

                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier.offset(y = offsetY)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.applyIf(
                            { isSelected },
                            Modifier
                                .paint(
                                    painter = painterResource(Res.drawable.ellipse),
                                    contentScale = ContentScale.FillBounds,
                                )
                                .clip(CircleShape)
                                .size(64.dp)
                                .padding(8.dp)

                        ).clickable(
                            onClick = { onItemSelected(item) },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(false),
                            role = Role.Button
                        )
                    ) {
                        AppImage(
                            item.icon(),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(iconTint)
                        )
                        Spacer(Modifier.height(2.dp))

                        if (isSelected.not()) {
                            Text(
                                item.localisedName(),
                                style = MaterialTheme.typography.labelMedium,
                                color = iconTint,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                        Spacer(Modifier.height(2.dp))
                        Box(
                            Modifier.size(indicatorSize)
                                .clip(CircleShape)
                                .background(iconTint)
                        )
                    }
                }
            }
        }

    }
}

