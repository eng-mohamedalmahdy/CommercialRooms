package ui.pages.articles

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.composables.AppTopBar
import ui.composables.SideMenuItem
import ui.config.AppIcons


@Composable
fun ArticlesPage() {
    val navigator = LocalNavigator.currentOrThrow
    LazyVerticalGrid(GridCells.Fixed(2)) {
        item(span = { GridItemSpan(3) }) {
            AppTopBar(
                leadingTitle = "Articles",
                onBackPress = navigator::pop
            )
        }
        items(10) {
            SideMenuItem(
                AppIcons.calendar,
                "Article $it"
            )
        }
    }
}


object ArticlesPageScreen : Screen{

    @Composable
    override fun Content() = ArticlesPage()

}
