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
import ui.entity.UiText

@Composable
fun AboutUsPage() {
    var selectedTab by remember { mutableStateOf(AboutUsTabs.entries.first()) }
    Column(Modifier.fillMaxSize()) {
        AppTopBar(
            leadingTitle = stringResource(MR.strings.welcome_back_user, "")
        )
        CircleIndicatorAppTabRow(
            AboutUsTabs.entries,
            AboutUsTabs.entries.map(AboutUsTabs::localizedName),
            selectedTab,
            onTabClick = { selectedTab = it }
        )
        Text(
            "عندما نتحدث",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(200.dp))
        Text(
            "عندما نتحدث",
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

fun AboutUsTabs.localizedName(): String {
    val res = when (this) {
        AboutUsTabs.About -> MR.strings.about_us
        AboutUsTabs.SupervisorWord -> MR.strings.our_mission
        AboutUsTabs.Vision -> MR.strings.our_vision

    }
    return UiText.StringResource(res).asString()

}