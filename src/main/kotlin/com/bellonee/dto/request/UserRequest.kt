package com.bellonee.dto.request

data class UserRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val address: String,
    val phoneNumber: String,
)