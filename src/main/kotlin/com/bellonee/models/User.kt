package com.bellonee.models

import kotlinx.serialization.Serializable


@Serializable
data class User (
    val id: Int,
    val fullName: String,
    val email: String,
    val address: String,
    val phoneNumber: String,
    val password: String,
    var authToken: String? = null,
    val createAt: String
)