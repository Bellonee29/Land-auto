package com.bellonee.repository

import com.bellonee.dto.request.LoginRequest
import com.bellonee.dto.request.UserRequest
import com.bellonee.services.UserService
import com.bellonee.utils.BaseResponse

class UserRepositoryImpl(    private  val userService: UserService) : UserRepository {
    override suspend fun registerUser(userRequest: UserRequest): BaseResponse<Any> {
        return if(userRequest.email.isNotEmpty()){
            BaseResponse.ErrorResponse("Email already exist")
        } else{
            val user = userService.registerUser(userRequest)
            if (user != null) {
                val token = JWTConfig.instance.createAccessToken(user.id)
                user.authToken = token
                BaseResponse.SuccessResponse(data = user, "User register successfully")
            } else{
                BaseResponse.ErrorResponse()
            }
        }
    }

    override suspend fun loginUser(loginRequest: LoginRequest): BaseResponse<Any> {
        TODO("Not yet implemented")
    }
}