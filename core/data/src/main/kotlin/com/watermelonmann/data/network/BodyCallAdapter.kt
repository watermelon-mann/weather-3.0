package com.watermelonmann.data.network

import java.io.IOException
import java.lang.reflect.Type
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response

class BodyCallAdapter<T : Any>(
    private val responseType: Type
) : CallAdapter<T, Flow<T?>> {

    override fun adapt(call: Call<T>): Flow<T?> {
        return callbackFlow {
            call.enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, throwable: Throwable) {
                    val networkResponse = when (throwable) {
                        is IOException -> NetworkError(cause = throwable)
                        else -> UnknownError(cause = throwable)
                    }
                    this@callbackFlow.close(networkResponse)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    try {
                        val body = response.body()
                        val code = response.code()

                        if (response.isSuccessful) {
                            close(trySend(body).exceptionOrNull())
                            return
                        } else {
                            val error = when (code) {
                                401 -> AuthorizeError()
                                403 -> ForbiddenException(response = response)
                                404 -> NotFoundException(response = response)
                                400 -> BadRequestException(response = response)
                                422 -> MalformedException(response = response)
                                409 -> ConflictException(response = response)
                                else -> ApiUnknownError()
                            }
                            this@callbackFlow.close(error)
                        }
                    } catch (e: Exception) {
                        this@callbackFlow.close(e)
                    }
                }
            })
            this@callbackFlow.awaitClose { call.cancel() }
        }
    }

    override fun responseType() = responseType
}
