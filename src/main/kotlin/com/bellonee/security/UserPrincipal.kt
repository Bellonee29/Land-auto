package com.bellonee.security

import io.ktor.server.auth.*

data class UserPrincipal  (val id: Int, val name: String, val email: String): Principal