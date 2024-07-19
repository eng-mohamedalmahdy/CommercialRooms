package ui.pages.aboutus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppTopBar
import ui.composables.CircleIndicatorAppTabRow

@Composable
fun AboutUsPage() {
    var selectedTab by remember { mutableStateOf(AboutUsTabs.entries.first()) }
    Column(Modifier.fillMaxSize()) {
        AppTopBar(
            leadingTitle = stringResource(MR.strings.welcome_back_user, "User")
        )
        CircleIndicatorAppTabRow(
            AboutUsTabs.entries,
            AboutUsTabs.entries.map(AboutUsTabs::name),
            selectedTab,
            onTabClick = { selectedTab = it }
        )
        Text(
            "When We Talk",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(200.dp))
        Text(
            "When We Talk",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(200.dp))
    }

}

object AboutUsPageScreen : Screen {

    @Composable
    override fun Content() = AboutUsPage()

}

enum class AboutUsTabs {
    About, SupervisorWord, Vision
}