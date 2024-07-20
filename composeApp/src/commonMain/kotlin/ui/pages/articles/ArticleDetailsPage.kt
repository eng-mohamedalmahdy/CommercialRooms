package ui.pages.articles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ui.composables.AppImage
import ui.config.AppIcons


@Composable
fun ArticleDetailsPage(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

        AppImage(
            AppIcons.activities,
            modifier = modifier.padding(16.dp).fillMaxWidth().height(250.dp)
        )

        Text("Article Details")


    }
}

object ArticleDetailsPageScreen : Screen {
    @Composable
    override fun Content() = ArticleDetailsPage()

}