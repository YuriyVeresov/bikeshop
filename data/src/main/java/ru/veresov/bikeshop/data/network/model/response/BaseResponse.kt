package ru.veresov.bikeshop.data.network.model.response


interface BaseResponse {
    val isSuccess: Boolean
    val code: Int?
    val message: String?
}