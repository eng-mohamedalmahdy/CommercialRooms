package ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
expect fun VideoPlayerView(videoUri: String, modifier: Modifier = Modifier)
