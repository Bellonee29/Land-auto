package com.bellonee.utils

import io.ktor.http.HttpStatusCode


sealed class BaseResponse<T> (  //read more about sealed class
    val statusCode: HttpStatusCode = HttpStatusCode.OK
){
    data class  SuccessResponse<T>(
        val data: T? = null,
        val message: String? = null
    ): BaseResponse<T>()

    data class  ErrorResponse<T>(
        val message: String? = null
    ): BaseResponse<T>()
}