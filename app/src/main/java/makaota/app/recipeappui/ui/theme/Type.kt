package makaota.app.recipeappui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import makaota.app.recipeappui.R

val Mukta = FontFamily(
    listOf(
        Font(R.font.mukta_regular, FontWeight.Normal),
        Font(R.font.mukta_medium, FontWeight.Medium),
        Font(R.font.mukta_light, FontWeight.Light),
        Font(R.font.mukta_extra_light, FontWeight.ExtraLight),
        Font(R.font.mukta_extra_bold, FontWeight.ExtraBold),
        Font(R.font.mukta_bold, FontWeight.Bold),
        Font(R.font.mukta__semi_bold, FontWeight.SemiBold),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = Color.Black,
        fontFamily = Mukta,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),

    body2 = TextStyle(
        color = Color.White,
        fontFamily = Mukta,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    h1 = TextStyle(
        color = Color.Black,
        fontFamily = Mukta,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        color = Color.White,
        fontFamily = Mukta,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )
)