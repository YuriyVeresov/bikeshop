package ru.veresov.bikeshop.ui.model

data class CatalogItemUi(
    val id: Int,
    val price: Float,
    val model: String,
    val isFavorite: Boolean,
    val resourceImageId: Int,
    val type: CatalogItemCategory,
)

sealed class CatalogItemCategory(val description: String) {
    data object Road : CatalogItemCategory(description = "Road Bike")
    data object Electric : CatalogItemCategory(description = "Electric Bike")
    data object Mountain : CatalogItemCategory(description = "Mountain Bike")
    data class Accessory(private val accessoryName: String) :
        CatalogItemCategory(description = accessoryName)
}