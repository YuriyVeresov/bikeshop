package ru.veresov.bikeshop.ui.mapper

import ru.veresov.bikeshop.domain.LoadCatalogResult
import ru.veresov.bikeshop.domain.model.CatalogItemDmn
import ru.veresov.bikeshop.domain.model.CatalogItemTypeDmn
import ru.veresov.bikeshop.ui.model.CatalogItemCategory
import ru.veresov.bikeshop.ui.model.CatalogItemUi
import ru.veresov.bikeshop.ui.screen.state.CatalogUiState

class CatalogUiMapper : LoadCatalogResult.CatalogMapper<CatalogUiState> {
    override fun mapSuccess(catalog: List<CatalogItemDmn>): CatalogUiState {
        val result = catalog.map { domainObject ->

            val car = when (domainObject.category?.type) {
                CatalogItemTypeDmn.ROAD -> CatalogItemCategory.Road
                CatalogItemTypeDmn.ACCESSORY -> CatalogItemCategory.Accessory(
                    domainObject.category?.description ?: "Untitled"
                )

                CatalogItemTypeDmn.MOUNTAIN -> CatalogItemCategory.Mountain
                CatalogItemTypeDmn.ELECTRIC -> CatalogItemCategory.Electric
                null -> CatalogItemCategory.Road
            }
            CatalogItemUi(
                domainObject.id,
                domainObject.price,
                domainObject.model,
                domainObject.isFavorite,
                domainObject.resourceImageId,
                car
            )
        }

        return CatalogUiState.Success(catalog = result)
    }

    override fun mapError(errorMessage: String, errorCode: Int): CatalogUiState {
        return CatalogUiState.Error(errorMessage, errorCode)
    }

}