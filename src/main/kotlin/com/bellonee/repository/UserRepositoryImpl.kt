package com.bellonee.repository

import com.bellonee.dto.request.LoginRequest
import com.bellonee.dto.request.UserRequest
import com.bellonee.services.UserService
import com.bellonee.utils.BaseResponse
import com.bellonee.utils.BaseResponse.ErrorResponse
import com.bellonee.utils.BaseResponse.SuccessResponse

class UserRepositoryImpl(
    private  val userService: UserService
) : UserRepository {
    override suspend fun registerUser(userRequest: UserRequest): BaseResponse<Any> =
        if(isEmailExist(userRequest.email)){
            ErrorResponse("Email already exist")
        } else{
            val user = userService.registerUser(userRequest)
            if (user != null) {
                //val token = JWTConfig.instance.createAccessToken(user.id)
                //user.authToken = token
                SuccessResponse(data = user, "User register successfully")
            } else{
                ErrorResponse()
            }
        }

    override suspend fun loginUser(loginRequest: LoginRequest): BaseResponse<Any> {
        TODO("Not yet implemented")
    }

    private suspend fun isEmailExist(email: String):Boolean{
        return userService.findUserByEmail(email) != null
    }
}