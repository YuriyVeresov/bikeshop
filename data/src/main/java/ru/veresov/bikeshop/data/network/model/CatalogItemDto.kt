package ru.veresov.bikeshop.data.network.model

import com.squareup.moshi.Json
import ru.veresov.bikeshop.domain.model.CatalogItemDmn
import ru.veresov.bikeshop.domain.model.CatalogItemTypeDmn
import ru.veresov.bikeshop.domain.model.ItemCategoryDmn

data class CatalogItemDto(
    @Json(name = "id") val id: Int,
    @Json(name = "price") val price: Float,
    @Json(name = "model") val model: String,
    @Json(name = "is_favorite") val isFavorite: Boolean,
    @Json(name = "resource_image_id") val resourceImageId: Int,
    @Json(name = "category") val category: ItemCategoryDto?,
) {
    fun toDomainObject() =
        CatalogItemDmn(id, price, model, isFavorite, resourceImageId, category?.toDomainObject())

}

data class ItemCategoryDto(
    @Json(name = "type") val type: CatalogItemTypeDto,
    @Json(name = "description") val description: String,
) {
    fun toDomainObject() = ItemCategoryDmn(CatalogItemTypeDmn.valueOf(type.name), description)
}

enum class CatalogItemTypeDto {
    ROAD, ACCESSORY, MOUNTAIN, ELECTRIC
}