package ru.veresov.bikeshop.data.network.data

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val message: String, val code: Int) : ResponseResult<Nothing>()
}