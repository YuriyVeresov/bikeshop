package ru.veresov.bikeshop.data.network.model.response

import com.squareup.moshi.Json
import ru.veresov.bikeshop.data.network.model.CatalogItemDto

data class CatalogItemsResponse(
    @Json(name = "is_success") override val isSuccess: Boolean,
    @Json(name = "error_code") override val code: Int?,
    @Json(name = "error_message") override val message: String?,
    @Json(name = "catalog_items") val items: List<CatalogItemDto>,
) : BaseResponse