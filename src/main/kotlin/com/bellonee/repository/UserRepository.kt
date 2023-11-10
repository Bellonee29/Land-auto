package com.bellonee.repository

import com.bellonee.dto.request.LoginRequest
import com.bellonee.dto.request.UserRequest
import com.bellonee.utils.BaseResponse

interface UserRepository {
    suspend fun registerUser(userRequest: UserRequest): BaseResponse<Any>
    suspend fun loginUser(loginRequest: LoginRequest): BaseResponse<Any>
}