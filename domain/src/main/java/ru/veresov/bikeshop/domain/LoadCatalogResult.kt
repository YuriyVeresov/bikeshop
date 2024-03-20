package ru.veresov.bikeshop.domain

import ru.veresov.bikeshop.domain.model.CatalogItemDmn

interface LoadCatalogResult {

    interface CatalogMapper<T : Any> {
        fun mapSuccess(catalog: List<CatalogItemDmn>): T
        fun mapError(errorMessage: String, errorCode: Int): T

    }

    fun <T : Any> map(mapper: CatalogMapper<T>): T

    data class Success(private val catalog: List<CatalogItemDmn>) : LoadCatalogResult {
        override fun <T : Any> map(mapper: CatalogMapper<T>): T {
            return mapper.mapSuccess(catalog)
        }
    }

    data class Error(private val errorMessage: String, private val errorCode: Int) :
        LoadCatalogResult {
        override fun <T : Any> map(mapper: CatalogMapper<T>): T {
            return mapper.mapError(errorMessage, errorCode)
        }
    }
}