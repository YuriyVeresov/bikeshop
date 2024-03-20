package ru.veresov.bikeshop.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.veresov.bikeshop.data.network.model.response.CatalogItemsResponse

interface BikeShopApi {
    @GET("catalog")
    suspend fun loadCatalog(): Response<CatalogItemsResponse>
}