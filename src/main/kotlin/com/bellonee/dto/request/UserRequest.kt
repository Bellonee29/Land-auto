package com.bellonee.dto.request

import com.bellonee.enums.Role

data class UserRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val address: String,
    val phoneNumber: String,
)