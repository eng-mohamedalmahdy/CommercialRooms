package ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import ui.config.Colors

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeHeaderPager(images: List<Any>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { images.size }
    )
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(images) {
        if (images.isNotEmpty()) {
            while (true) {
                delay(3000) // Delay for 3 seconds
                coroutineScope.launch {
                    pagerState.animateScrollToPage((pagerState.currentPage + 1) % images.size)
                }
            }
        }
    }

    Box(modifier = modifier) {

        HorizontalPager(pagerState) {
            Card(
                modifier = modifier.padding(0.dp),
                shape = RectangleShape
            ) {
                Box {

                    AppImage(
                        model = images[it],
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                    )
                    Box(modifier.fillMaxSize().background(Color.DarkGray.copy(alpha = 0.6f)))
                }
            }
        }

        DotsIndicator(
            images.size,
            pagerState.currentPage,
            modifier = Modifier.align(Alignment.BottomCenter).padding(vertical = 12.dp)
        )
    }
}