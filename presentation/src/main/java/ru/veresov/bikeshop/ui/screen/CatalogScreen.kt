package ru.veresov.bikeshop.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ru.veresov.bikeshop.ui.component.CatalogItem
import ru.veresov.bikeshop.ui.component.CatalogItemShimmer
import ru.veresov.bikeshop.ui.screen.state.CatalogUiState

@Composable
fun CatalogScreen(
    modifier: Modifier,
) {
    val scrollState = rememberLazyStaggeredGridState()
    val context = LocalContext.current
    val viewModel = (context.applicationContext as ViewModelProvider).provideCatalogViewModel()

    val screenState = viewModel.externalCatalogData.observeAsState(CatalogUiState.Loading)

    screenState.value.let { uiState ->
        when (uiState) {

            is CatalogUiState.Error -> {
                Toast.makeText(context, uiState.errorMessage, Toast.LENGTH_SHORT).show()
            }

            CatalogUiState.Loading -> {
                LazyVerticalStaggeredGrid(
                    state = scrollState,
                    modifier = modifier,
                    columns = StaggeredGridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    content = {
                        items(10) { index ->
                            val paddingTop = when (index) {
                                0 -> 20
                                1 -> 0
                                else -> 10
                            }
                            val height = if (index % 2 == 0) {
                                241
                            } else {
                                219
                            }
                            CatalogItemShimmer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = paddingTop.dp)
                                    .height(height = height.dp),
                            )
                        }
                    })
            }

            is CatalogUiState.Success -> {
                LazyVerticalStaggeredGrid(state = scrollState,
                    modifier = modifier,
                    columns = StaggeredGridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    content = {
                        itemsIndexed(uiState.catalog) { index, product ->
                            val paddingTop = when (index) {
                                0 -> 20
                                1 -> 0
                                else -> 10
                            }
                            val height = if (index % 2 == 0) {
                                241
                            } else {
                                219
                            }
                            CatalogItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = paddingTop.dp)
                                    .height(height = height.dp),
                                item = product,
                            )
                        }
                    })
            }
        }
    }
}
