package com.watermelonmann.data.network

import retrofit2.Response

class ApiUnknownError(text: String = "", cause: Throwable? = null) : Exception(text, cause)

class NotFoundException(
    val text: String = "",
    override val cause: Throwable? = null,
    val response: Response<*>? = null
) : Exception(text, cause)

class ForbiddenException(
    val text: String = "",
    override val cause: Throwable? = null,
    val response: Response<*>? = null
) : Exception(text, cause)

class BadRequestException(
    val text: String = "",
    override val cause: Throwable? = null,
    val response: Response<*>? = null
) : Exception(text, cause)

class MalformedException(
    text: String = "",
    cause: Throwable? = null,
    val response: Response<*>? = null
) : Exception(text, cause)

class ConflictException(
    text: String = "",
    cause: Throwable? = null,
    val response: Response<*>? = null
) : Exception(text, cause)

class AuthorizeError : Exception()

class NetworkError(text: String? = null, cause: Throwable?) : Exception(text, cause)

class UnknownError(cause: Throwable?) : Exception(cause)