package ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import ui.config.AppIcons
import ui.entity.UiService

@Composable
fun ServiceCard(service: UiService, modifier: Modifier = Modifier) {
    Card(modifier.size(100.dp).padding(8.dp)) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppImage(
                service.image,
                modifier = Modifier.size(32.dp),
                error = painterResource(AppIcons.services)
            )
            Spacer(Modifier.height(8.dp))
            Text(service.name)
        }
    }

}