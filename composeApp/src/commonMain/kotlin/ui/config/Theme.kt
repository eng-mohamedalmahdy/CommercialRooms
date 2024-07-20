package ui.config

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import androidx.compose.material3.*


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF05375F),
    onPrimary = Color.White,
    primaryContainer = Color(0xff05375f),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF9B9B9B),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF9B9B9B),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFD93133),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFD93133),
    background = Color.White,
    onBackground = Color.Black,
    surface = Color(0x59d9d9d9),
    onSurface = Color.Black,
    error = Colors.error,
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF05375F),
    onPrimary = Color.White,
    primaryContainer = Color(0xff05375f),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF9B9B9B),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF9B9B9B),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFD93133),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFD93133),
    background = Color.White,
    onBackground = Color.Black,
    surface = Color(0x59d9d9d9),
    onSurface = Color.Black,
    error = Colors.error,
    onError = Color.White
)

object Colors {
    val personalChannel: Color = Color(0xfff5c1ac)
    val membershipChannel: Color = Color(0xFFe5fd7c)
    val allChannel: Color = Color(0xffcbc4ff)
    val success = Color(0xff34c759)
    val error = Color(0XFFFF3B30)
    val pending = Color(0xfff0ff84)
}

private val appTypography
    @Composable get() = Typography(
        displayLarge = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        ),
        displayMedium = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        ),
        displaySmall = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        headlineLarge = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        ),
        headlineMedium = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        ),
        headlineSmall = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        titleLarge = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        ),
        titleMedium = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        ),
        bodyLarge = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        bodyMedium = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        bodySmall = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        ),
        labelLarge = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal
        ),
        labelMedium = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 10.sp,
            fontWeight = FontWeight.Thin
        ),
        labelSmall = TextStyle(
            fontFamily = cairoFontFamily,
            fontSize = 9.sp,
            fontWeight = FontWeight.Normal
        )
    )

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = if (darkTheme) {
        LightColorScheme
//        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = appTypography,
        shapes = shapes,
        content = content
    )
}
