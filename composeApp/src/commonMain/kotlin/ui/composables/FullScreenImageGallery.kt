package ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch
import ui.modifiers.previewBackground


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FullScreenImageGallery(
    images: List<Any>,
    initialPage: Int = 0,
    onDismiss: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(initialPage = initialPage, pageCount = { images.size })



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.9f))
            .zIndex(10f)
            .clickable {
                onDismiss()
            },
        contentAlignment = Alignment.Center
    ) {

        HorizontalPager(pagerState) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {

                // set up all transformation states
                var scale by remember { mutableFloatStateOf(1f) }
                var rotation by remember { mutableFloatStateOf(0f) }
                val transformState = rememberTransformableState { zoomChange, _, rotationChange ->
                    scale *= zoomChange
                    rotation += rotationChange
                }

                AppImage(
                    model = images[page],
                    modifier = Modifier
                        .previewBackground(Color.Red)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(400.dp)
                        .padding(4.dp)
                        .clipToBounds()
                        .clip(RoundedCornerShape(16.dp))
                        .border(BorderStroke(1.dp, Color.White), RoundedCornerShape(16.dp))
                        .transformable(state = transformState)
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            rotationZ = rotation,
                        ),
                    contentScale = ContentScale.FillBounds,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    // Left Arrow Button
                    if (page > 0) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                            contentDescription = "Previous Image",
                            modifier = Modifier
                                .clickable {
                                    coroutineScope.launch { pagerState.animateScrollToPage(page - 1) }
                                }
                                .padding(horizontal = 28.dp)
                                .size(48.dp),
                            tint = Color.White
                        )
                    }

                    Spacer(Modifier.weight(1f))

                    // Right Arrow Button
                    if (page < images.size - 1) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = "Next Image",
                            modifier = Modifier
                                .clickable {
                                    coroutineScope.launch { pagerState.animateScrollToPage(page + 1) }
                                }
                                .padding(horizontal = 16.dp)
                                .size(48.dp),
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }

}