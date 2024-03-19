package ru.veresov.bikeshop.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.veresov.bikeshop.R

@Stable
data class BikeShopTypography(
    val headerLarge: TextStyle,
    val headerNormal: TextStyle,
    val bodyLarge: TextStyle,
    val bodyNormal: TextStyle,
    val bodyNormalBold: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallMedium: TextStyle,
)

private val Poppins = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal)
)

private val headerLarge = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Bold,
    fontSize = 26.sp
)

private val headerNormal = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)

private val bodyLarge = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Bold,
    fontSize = 17.sp
)

private val bodyNormal = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp
)

private val bodyNormalBold = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Bold,
    fontSize = 15.sp
)

private val bodySmall = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp
)

private val bodySmallMedium = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Medium,
    fontSize = 13.sp
)

val typography = BikeShopTypography(
    headerLarge = headerLarge,
    headerNormal = headerNormal,
    bodyLarge = bodyLarge,
    bodyNormal = bodyNormal,
    bodyNormalBold = bodyNormalBold,
    bodySmall = bodySmall,
    bodySmallMedium = bodySmallMedium
)


val LocalBikeShopBikeShopTypography = staticCompositionLocalOf {
    BikeShopTypography(
        headerLarge = headerLarge,
        headerNormal = headerNormal,
        bodyLarge = bodyLarge,
        bodyNormal = bodyNormal,
        bodyNormalBold = bodyNormalBold,
        bodySmall = bodySmall,
        bodySmallMedium = bodySmallMedium
    )

}