package com.bellonee.models

import com.bellonee.enums.Role
import kotlinx.serialization.Serializable


@Serializable
data class User(
    val id: Int,
    val fullName: String,
    val userName: String,
    val email: String,
    var role: Role = Role.CUSTOMER,
    val address: String,
    val phoneNumber: String,
    val password: String,
    //val confirmPassword: String,
    var authToken: String? = null,
    val createAt: String
)


