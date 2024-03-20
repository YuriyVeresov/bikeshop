package ru.veresov.bikeshop.data.network.data

import retrofit2.Response
import ru.veresov.bikeshop.data.network.model.response.BaseResponse

internal interface ApiDataFetcher {
    suspend fun <T : BaseResponse> executeRequest(request: suspend () -> Response<T>): ResponseResult<T>
}
