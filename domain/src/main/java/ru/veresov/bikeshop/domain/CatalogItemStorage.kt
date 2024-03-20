package ru.veresov.bikeshop.domain


interface CatalogItemStorage {
    suspend fun loadCatalog(): LoadCatalogResult
}