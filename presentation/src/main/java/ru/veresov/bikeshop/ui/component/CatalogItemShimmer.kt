package ru.veresov.bikeshop.ui.component

import android.view.MotionEvent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.veresov.bikeshop.ui.utils.shimmer

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CatalogItemShimmer(
    modifier: Modifier,
    cardParams: CardParameters = CardParameters(cornerRadius = 20, borderWidth = 2, bias = 50f),
) {

    var isTapped by remember { mutableStateOf(false) }

    val animatedPadding by animateDpAsState(
        if (isTapped) {
            1.dp
        } else {
            0.dp
        },
        label = "padding"
    )

    CatalogItemBackground(
        modifier = modifier
            .padding(animatedPadding)
            .pointerInteropFilter { event: MotionEvent ->
                isTapped = event.action == MotionEvent.ACTION_DOWN
                return@pointerInteropFilter true
            },
        cardParams = cardParams,
        isTapped = isTapped
    )
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .size(24.dp)
                    .shimmer(RoundedCornerShape(30))
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.45f)
                    .shimmer(RoundedCornerShape(10))
            )

            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.6f)
                        .height(18.dp)
                        .shimmer(RoundedCornerShape(10.dp)),
                )
                Box(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .fillMaxWidth(.7f)
                        .height(18.dp)
                        .shimmer(RoundedCornerShape(10.dp))

                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .height(18.dp)
                        .shimmer(RoundedCornerShape(10.dp)),
                )
            }
        }
    }
}

@Composable
@Preview
private fun CatalogShimmerItemPreview() {
    CatalogItemShimmer(
        modifier = Modifier
            .width(165.dp)
            .height(height = 241.dp),
    )
}