package ru.veresov.bikeshop.ui.screen.state

import ru.veresov.bikeshop.ui.model.CatalogItemUi

sealed interface CatalogUiState {
    data object Loading : CatalogUiState
    data class Success(val catalog: List<CatalogItemUi>) : CatalogUiState
    data class Error(val errorMessage: String, val errorCode: Int) : CatalogUiState
}