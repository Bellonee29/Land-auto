package com.bellonee.repository

import com.bellonee.dto.request.LoginRequest
import com.bellonee.dto.request.UserRequest
import com.bellonee.models.User
import com.bellonee.security.JWTConfiguration
import com.bellonee.security.hash
import com.bellonee.services.UserService
import com.bellonee.tables.UserTable.password
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
                val token = JWTConfiguration.instance.createAccessToken(user.id, user.fullName, user.email)
                user.authToken = token
                SuccessResponse(data = user, "User register successfully")
            } else{
                ErrorResponse()
            }
        }

    override suspend fun loginUser(loginRequest: LoginRequest): BaseResponse<Any> {
        val user = userService.findUserByEmail(loginRequest.email)
        return if (user != null && isPasswordValid(user, loginRequest.password)) {
            val token = JWTConfiguration.instance.createAccessToken(user.id, user.fullName, user.email)
            user.authToken = token
            SuccessResponse(data = user, message = "Login successful")
        } else {
            ErrorResponse(message = "Invalid email or password")
        }
    }

    private suspend fun isEmailExist(email: String):Boolean{
        return userService.findUserByEmail(email) != null
    }

    private fun isPasswordValid(user: User, password: String): Boolean {
        val hashedPassword = hash(password) // Hash the provided password
        return hashedPassword == user.password
    }

}