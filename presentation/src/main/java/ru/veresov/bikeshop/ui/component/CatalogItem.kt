package ru.veresov.bikeshop.ui.component

import android.view.MotionEvent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.veresov.bikeshop.R
import ru.veresov.bikeshop.ui.model.CatalogItemCategory
import ru.veresov.bikeshop.ui.model.CatalogItemUi
import ru.veresov.bikeshop.ui.theme.BikeShopTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CatalogItem(
    modifier: Modifier,
    cardParams: CardParameters = CardParameters(cornerRadius = 20, borderWidth = 2, bias = 50f),
    item: CatalogItemUi?,
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

    Box {
        Box(
            modifier = modifier.padding(animatedPadding + 16.dp),
            contentAlignment = Alignment.Center

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    modifier = Modifier.align(Alignment.End),
                    imageVector = if (item!!.isFavorite) ImageVector.vectorResource(id = R.drawable.ic_favorite_remove)
                    else ImageVector.vectorResource(id = R.drawable.ic_favorite_add),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    painter = painterResource(id = R.drawable.bike_placeholder),
                    contentDescription = null
                )

                Column {
                    Text(
                        text = item.type.description,
                        style = BikeShopTheme.typography.bodySmallMedium,
                        color = BikeShopTheme.colorScheme.primaryTextColorTransparent
                    )
                    Text(
                        text = item.model,
                        style = BikeShopTheme.typography.bodyNormalBold,
                        color = BikeShopTheme.colorScheme.primaryTextColor
                    )
                    Text(
                        text = "$ ${item.price}",
                        style = BikeShopTheme.typography.bodySmallMedium,
                        color = BikeShopTheme.colorScheme.primaryTextColorTransparent
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun CatalogItemPreview() {
    val mockProduct = CatalogItemUi(
        id = 1,
        price = 1333f,
        model = "PEUGEOT - LR01",
        type = CatalogItemCategory.Road,
        isFavorite = false,
        resourceImageId = R.drawable.bike_placeholder
    )
    CatalogItem(
        modifier = Modifier
            .width(165.dp)
            .height(height = 241.dp),
        item = mockProduct,
    )
}