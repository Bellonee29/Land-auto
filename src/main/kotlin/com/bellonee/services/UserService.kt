package com.bellonee.services

import com.bellonee.dto.request.LoginRequest
import com.bellonee.dto.request.UserRequest
import com.bellonee.models.User

interface UserService {
    suspend fun registerUser(userRequest: UserRequest): User?
    suspend fun loginUser(loginRequest: LoginRequest)
    suspend fun findUserByEmail(email: String): User?
    suspend fun findAllUser(): List<User>
}