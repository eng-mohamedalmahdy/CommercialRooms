package ui.pages.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.lightfeather.commercialrooms.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.composables.AppImage
import ui.composables.AppTopBar
import ui.composables.CircleIndicatorAppTabRow

@Composable
fun NewsPage() {
    var selectedNewsTab by remember { mutableStateOf<NewsType>(NewsType.LATEST) }
    var news by remember { mutableStateOf(List(10) { "" }) }
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            AppTopBar(
                leadingTitle = stringResource(MR.strings.welcome_back_user, "User")
            )
        }
        item {
            TabRow(
                selectedNewsTab.ordinal,
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                indicator = {

                }
            ) {

                CircleIndicatorAppTabRow(
                    NewsType.entries,
                    NewsType.entries.map(NewsType::name),
                    selectedNewsTab,
                    onTabClick = { selectedNewsTab = it }
                )
            }
        }
        items(news) {
            AppImage(
                it,
                modifier = Modifier.padding(8.dp).fillMaxWidth().height(100.dp).clickable(
                    onClick = {},
                    role = Role.Image
                ).background(MaterialTheme.colorScheme.primary.copy(alpha = 0.25f))
            )
        }
        item {
            Spacer(Modifier.height(150.dp))
        }

    }
}

object NewsPageScreen : Screen {
    @Composable
    override fun Content() = NewsPage()
}

enum class NewsType {
    LATEST, EVENTS, LENS, CONFERENCES
}