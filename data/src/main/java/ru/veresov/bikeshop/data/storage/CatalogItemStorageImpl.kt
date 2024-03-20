package ru.veresov.bikeshop.data.storage

import ru.veresov.bikeshop.data.network.BikeShopApi
import ru.veresov.bikeshop.data.network.data.RemoteDataFetcher
import ru.veresov.bikeshop.data.network.data.ResponseResult
import ru.veresov.bikeshop.domain.CatalogItemStorage
import ru.veresov.bikeshop.domain.LoadCatalogResult

class CatalogItemStorageImpl(
    private val api: BikeShopApi,
) : RemoteDataFetcher(), CatalogItemStorage {

    override suspend fun loadCatalog(): LoadCatalogResult {
        val loadResult = when (val response = executeRequest { api.loadCatalog() }) {
            is ResponseResult.Error -> {
                LoadCatalogResult.Error(
                    response.message,
                    response.code
                )
            }

            is ResponseResult.Success -> {
                LoadCatalogResult.Success(response.data.items.map { it.toDomainObject() })
            }
        }
        return loadResult
    }
}


