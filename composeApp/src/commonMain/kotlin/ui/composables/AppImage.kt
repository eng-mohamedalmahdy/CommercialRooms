package ui.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppImage(
    model: Any,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
    colorFilter: ColorFilter? = null
) {
    when (model) {

        is ImageVector -> Image(
            imageVector = model,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            colorFilter = colorFilter
        )

        is Painter -> Image(
            painter = model,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            colorFilter = colorFilter
        )

        is DrawableResource -> Image(
            painter = painterResource(model),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            colorFilter = colorFilter
        )


        else -> {
            val imageModel = when {
                model is String && model.endsWith(".svg") -> ImageRequest.Builder(LocalPlatformContext.current)
                    .data(model)
                    .decoderFactory(SvgDecoder.Factory())
                    .build()

                model is String && model.endsWith(".mp4") -> ImageRequest.Builder(LocalPlatformContext.current)
                    .data(model)
                    .build()

                else -> model
            }

            AsyncImage(
                model = imageModel,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                placeholder = placeholder,
                error = error,
                colorFilter = colorFilter
            )
        }
    }
}