package com.jh.domain.model

sealed class Response<out T> {

    class Success<T>(val data: T) : Response<T>()

    class ApiError(val throwable: Throwable) : Response<Nothing>()

    object Loading : Response<Nothing>()
}