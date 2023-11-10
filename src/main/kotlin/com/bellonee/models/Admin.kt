package com.bellonee.models

import kotlinx.serialization.Serializable

@Serializable
data class Admin (
    val id: Int,
    val fullName: String,
    val email: String,
    val password: String
) {
}