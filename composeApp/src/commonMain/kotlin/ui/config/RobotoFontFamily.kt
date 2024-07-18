package ui.config

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import commercialrooms.composeapp.generated.resources.Res
import commercialrooms.composeapp.generated.resources.roboto_black
import commercialrooms.composeapp.generated.resources.roboto_blackitalic
import commercialrooms.composeapp.generated.resources.roboto_bold
import commercialrooms.composeapp.generated.resources.roboto_bolditalic
import commercialrooms.composeapp.generated.resources.roboto_italic
import commercialrooms.composeapp.generated.resources.roboto_light
import commercialrooms.composeapp.generated.resources.roboto_medium
import commercialrooms.composeapp.generated.resources.roboto_mediumitalic
import commercialrooms.composeapp.generated.resources.roboto_regular
import commercialrooms.composeapp.generated.resources.roboto_thin
import commercialrooms.composeapp.generated.resources.roboto_thinitalic
import commercialrooms.composeapp.generated.resources.sf_pro_black_italic
import commercialrooms.composeapp.generated.resources.sf_pro_bold
import commercialrooms.composeapp.generated.resources.sf_pro_light_italic
import commercialrooms.composeapp.generated.resources.sf_pro_medium
import commercialrooms.composeapp.generated.resources.sf_pro_regular
import commercialrooms.composeapp.generated.resources.sf_pro_semi_bold_italic
import commercialrooms.composeapp.generated.resources.sf_pro_thin_italic


import org.jetbrains.compose.resources.Font

// Roboto Font Family
val robotoFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.roboto_thin, FontWeight.Thin, FontStyle.Normal),
        Font(Res.font.roboto_thinitalic, FontWeight.Thin, FontStyle.Italic),
        Font(Res.font.roboto_light, FontWeight.Light, FontStyle.Normal),
        Font(Res.font.sf_pro_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(Res.font.roboto_regular, FontWeight.Normal, FontStyle.Normal),
        Font(Res.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
        Font(Res.font.roboto_medium, FontWeight.Medium, FontStyle.Normal),
        Font(Res.font.roboto_mediumitalic, FontWeight.Medium, FontStyle.Italic),
        Font(Res.font.roboto_bold, FontWeight.Bold, FontStyle.Normal),
        Font(Res.font.roboto_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(Res.font.roboto_black, FontWeight.Black, FontStyle.Normal),
        Font(Res.font.roboto_blackitalic, FontWeight.Black, FontStyle.Italic)
    )

// SF Pro Font Family
val sfproFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.sf_pro_regular, FontWeight.Thin, FontStyle.Normal),
        Font(Res.font.sf_pro_thin_italic, FontWeight.Thin, FontStyle.Italic),
        Font(Res.font.roboto_light, FontWeight.Light, FontStyle.Normal),
        Font(Res.font.sf_pro_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(Res.font.sf_pro_regular, FontWeight.Normal, FontStyle.Normal),
        Font(Res.font.sf_pro_semi_bold_italic, FontWeight.Normal, FontStyle.Italic),
        Font(Res.font.sf_pro_medium, FontWeight.Medium, FontStyle.Normal),
        Font(Res.font.roboto_mediumitalic, FontWeight.Medium, FontStyle.Italic),
        Font(Res.font.sf_pro_bold, FontWeight.Bold, FontStyle.Normal),
        Font(Res.font.roboto_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(Res.font.roboto_blackitalic, FontWeight.Black, FontStyle.Normal),
        Font(Res.font.sf_pro_black_italic, FontWeight.Black, FontStyle.Italic)
    )
