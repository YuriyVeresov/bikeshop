package ru.veresov.bikeshop.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.veresov.bikeshop.domain.CatalogItemStorage
import ru.veresov.bikeshop.domain.LoadCatalogResult
import ru.veresov.bikeshop.ui.screen.state.CatalogUiState

interface ViewModelProvider {
    fun provideCatalogViewModel(): CatalogScreenViewModel
}


class CatalogScreenViewModel(
    private val catalogItemStorage: CatalogItemStorage,
    private val catalogMapper: LoadCatalogResult.CatalogMapper<CatalogUiState>,
) : ViewModel() {

    private val _internalCatalogData = MutableLiveData<CatalogUiState>()
    val externalCatalogData: LiveData<CatalogUiState> = _internalCatalogData

    init {
        loadCatalog()
    }

    private fun loadCatalog() {
        viewModelScope.launch {
            val result = catalogItemStorage.loadCatalog()
            _internalCatalogData.postValue(result.map(catalogMapper))
        }
    }

}