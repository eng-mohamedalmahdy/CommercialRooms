package ui.pages.articles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.composables.AppTopBar
import ui.composables.SideMenuItem
import ui.config.AppIcons


@Composable
fun ArticlesPage() {
    val navigator = LocalNavigator.currentOrThrow
//    Text("TEST")
    LazyVerticalGrid(
        GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        item(span = { GridItemSpan(3) }) {
            AppTopBar(
                leadingTitle = "المقالات",
                onBackPress = navigator::pop
            )
        }
        items(10) {
            SideMenuItem(
                AppIcons.calendar,
                "مقال $it",
                modifier = Modifier.clickable {
                    navigator.push(ArticleDetailsPageScreen)
                }.padding(8.dp)
            )
        }
    }
}


object ArticlesPageScreen : Screen {

    @Composable
    override fun Content() = ArticlesPage()

}
