package ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerWithIndicatorAndTitle(title: String, items: List<Any>, onItemClick: () -> Unit) {
    val pagerState = rememberPagerState { items.size }
    Column(Modifier.fillMaxWidth().padding(8.dp)) {
        Text(
            title,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(8.dp))
        HorizontalPager(pagerState) {
            AppImage(
                items[it],
                modifier = Modifier.padding(8.dp).fillMaxWidth().height(100.dp).clickable(
                    onClick = onItemClick,
                    role = Role.Image
                ).background(MaterialTheme.colorScheme.primary.copy(alpha = 0.25f))
            )
        }
        DotsIndicator(
            pagerState.pageCount,
            pagerState.currentPage,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }

}