package ru.veresov.bikeshop.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.veresov.bikeshop.ui.theme.BikeShopTheme


data class CardParameters(
    val cornerRadius: Int,
    val borderWidth: Int,
    val bias: Float,
)

@Composable
fun CatalogItemBackground(
    modifier: Modifier,
    cardParams: CardParameters,
    isTapped: Boolean,
) {

    val borderColors = BikeShopTheme.colorScheme.strokeGradientColors
    val cardColors = BikeShopTheme.colorScheme.cardBackgroundGradientColors

    val animatedAlpha by animateFloatAsState(
        targetValue = if (isTapped) .0f else .6f,
        label = "alpha"
    )


    Canvas(
        modifier = modifier,
        onDraw = {
            val width = size.width
            val height = size.height - cardParams.bias
            val radius = cardParams.cornerRadius.dp.toPx()
            val borderWidth = cardParams.borderWidth.dp.toPx()

            val cardPath = Path().apply {
                moveTo(0f, height + cardParams.bias)
                lineTo(0f, cardParams.bias)
                lineTo(width, 0f)
                lineTo(width, height)
                close()
            }

            val cardPathEffect = PathEffect.cornerPathEffect(radius = radius)

            val cardBackgroundPaint = Paint().apply {
                pathEffect = cardPathEffect
                shader = LinearGradientShader(
                    from = Offset.Zero,
                    to = Offset(width, height),
                    colors = cardColors
                )
                alpha = animatedAlpha
            }

            val borderPaint = Paint().apply {
                pathEffect = cardPathEffect
                style = PaintingStyle.Stroke
                strokeWidth = borderWidth
                shader = LinearGradientShader(
                    from = Offset.Zero,
                    to = Offset(width, height),
                    colors = borderColors
                )
                alpha = .2f
            }

            drawIntoCanvas { canvas ->
                canvas.drawPath(cardPath, cardBackgroundPaint)
                canvas.drawOutline(
                    Outline.Generic(path = cardPath),
                    paint = borderPaint
                )
            }

        })
}

@Composable
@Preview
private fun CatalogCardBackgroundPreview() {
    val mockCardParams = CardParameters(cornerRadius = 20, borderWidth = 2, bias = 50f)

    CatalogItemBackground(
        modifier = Modifier.fillMaxSize(),
        cardParams = mockCardParams,
        isTapped = false
    )
}