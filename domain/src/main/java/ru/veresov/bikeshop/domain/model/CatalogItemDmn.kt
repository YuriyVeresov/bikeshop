package ru.veresov.bikeshop.domain.model

data class CatalogItemDmn(
    val id: Int,
    val price: Float,
    val model: String,
    val isFavorite: Boolean,
    val resourceImageId: Int,
    val category: ItemCategoryDmn?,
)

data class ItemCategoryDmn(
    val type: CatalogItemTypeDmn,
    val description: String,
)

enum class CatalogItemTypeDmn {
    ROAD, ACCESSORY, MOUNTAIN, ELECTRIC
}
