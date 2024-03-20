package ru.veresov.bikeshop.data.network.data

import retrofit2.Response
import ru.veresov.bikeshop.data.network.model.response.BaseResponse

abstract class RemoteDataFetcher : ApiDataFetcher {
    override suspend fun <T : BaseResponse> executeRequest(request: suspend () -> Response<T>): ResponseResult<T> {
        return try {
            val result = request.invoke()
            val response = result.body()

            when {
                result.isSuccessful && response != null -> {
                    if (response.isSuccess) {
                        ResponseResult.Success(response)
                    } else {
                        ResponseResult.Error(
                            message = response.message ?: "Unknown error",
                            code = response.code ?: 444
                        )
                    }
                }

                result.isSuccessful -> ResponseResult.Error(
                    message = "Empty response body",
                    code = 333
                )

                else -> ResponseResult.Error(
                    message = "Network request failed",
                    code = 222
                )
            }
        } catch (e: Exception) {
            ResponseResult.Error(
                message = "Check Network Connection",
                code = 111
            )
        }
    }
}