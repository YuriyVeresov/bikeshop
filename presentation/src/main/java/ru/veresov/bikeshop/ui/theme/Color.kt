package ru.veresov.bikeshop.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
data class BikeShopColors(
    val backgroundColor: Color,
    val secondaryBackgroundColor: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val primaryTextColorTransparent: Color,
    val strokeGradientColors: List<Color>,
    val cardBackgroundGradientColors: List<Color>,
    val secondaryBackgroundGradientColors: List<Color>,
)


val lightPalette = BikeShopColors(
    backgroundColor = Color(0xFF242C3B),
    secondaryBackgroundColor = Color(0xFF37B6E9),
    primaryTextColor = Color(0xFFFFFFFF),
    secondaryTextColor = Color(0xFF3C9EEA),
    primaryTextColorTransparent = Color(0x99FFFFFF),
    strokeGradientColors = listOf(
        Color(0xFFFFFFFF),
        Color(0xFFD2D2D2),
        Color(0xFFA6A6A6),
        Color(0xFF7A7A7A),
        Color(0xFF4E4E4E),
        Color(0xFF232323),
        Color(0xFF111111),
        Color(0xFF000000),
    ),
    cardBackgroundGradientColors = listOf(
        Color(0xFF353F54),
        Color(0xFF333C50),
        Color(0xFF30394C),
        Color(0xFF2E3648),
        Color(0xFF293040),
        Color(0xFF272E3C),
        Color(0xFF242B38),
        Color(0xFF222834)
    ),
    secondaryBackgroundGradientColors = listOf(
        Color(0xFF37B6E9),
        Color(0xFF39AAE9),
        Color(0xFF3C9EEA),
        Color(0xFF3E92EA),
        Color(0xFF4087EB),
        Color(0xFF427AEB),
        Color(0xFF456EEC),
        Color(0xFF4763EC),
        Color(0xFF4958ED),
        Color(0xFF4B4CED),
    ),
)


val darkPalette = BikeShopColors(
    backgroundColor = Color(0xFF1E1E1E),
    secondaryBackgroundColor = Color(0xFF292929),
    primaryTextColor = Color(0xFFFFFFFF),
    secondaryTextColor = Color(0xFFBDBDBD),
    primaryTextColorTransparent = Color(0x99FFFFFF),
    strokeGradientColors = listOf(
        Color(0xFF121212),
        Color(0xFF333333),
        Color(0xFF555555),
        Color(0xFF777777),
        Color(0xFF999999),
        Color(0xFFBBBBBB),
        Color(0xFFDDDDDD),
        Color(0xFFFFFFFF),
    ),
    cardBackgroundGradientColors = listOf(
        Color(0xFF202020),
        Color(0xFF1D1D1D),
        Color(0xFF1A1A1A),
        Color(0xFF171717),
        Color(0xFF141414),
        Color(0xFF111111),
        Color(0xFF0E0E0E),
        Color(0xFF0B0B0B)

    ),
    secondaryBackgroundGradientColors = listOf(
        Color(0xFF1E4D7D),
        Color(0xFF1C4A7D),
        Color(0xFF1A477E),
        Color(0xFF18447E),
        Color(0xFF15417F),
        Color(0xFF133E7F),
        Color(0xFF113B80),
        Color(0xFF0F3880),
        Color(0xFF0D3581),
        Color(0xFF0B3381)
    ),
)


val LocalBikeShopAppColorScheme = staticCompositionLocalOf {
    BikeShopColors(
        backgroundColor = Color(0xFF242C3B),
        secondaryBackgroundColor = Color(0xFF37B6E9),
        primaryTextColor = Color(0xFFFFFFFF),
        secondaryTextColor = Color(0xFF3C9EEA),
        primaryTextColorTransparent = Color(0x99FFFFFF),
        strokeGradientColors = listOf(
            Color(0xFFFFFFFF),
            Color(0xFFD2D2D2),
            Color(0xFFA6A6A6),
            Color(0xFF7A7A7A),
            Color(0xFF4E4E4E),
            Color(0xFF232323),
            Color(0xFF111111),
            Color(0xFF000000),
        ),
        cardBackgroundGradientColors = listOf(
            Color(0xFF353F54),
            Color(0xFF333C50),
            Color(0xFF30394C),
            Color(0xFF2E3648),
            Color(0xFF293040),
            Color(0xFF272E3C),
            Color(0xFF242B38),
            Color(0xFF222834)
        ),
        secondaryBackgroundGradientColors = listOf(
            Color(0xFF37B6E9),
            Color(0xFF39AAE9),
            Color(0xFF3C9EEA),
            Color(0xFF3E92EA),
            Color(0xFF4087EB),
            Color(0xFF427AEB),
            Color(0xFF456EEC),
            Color(0xFF4763EC),
            Color(0xFF4958ED),
            Color(0xFF4B4CED),
        ),
    )
}