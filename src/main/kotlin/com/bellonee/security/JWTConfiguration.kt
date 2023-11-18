package com.bellonee.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.bellonee.enums.Role

class JWTConfiguration private constructor(secret: String){
    private val algorithm = Algorithm.HMAC256(secret)

    val verifier: JWTVerifier = JWT
        .require(algorithm)
        .withIssuer(ISSUER)
        .withAudience(AUDIENCE)
        .build()

    fun createAccessToken (id: Int, name: String, email: String, role: Role): String = JWT
        .create()
        .withIssuer(ISSUER)
        .withAudience(AUDIENCE)
        .withClaim(CLAIM_id, id)
        .withClaim(CLAIM_name,name)
        .withClaim(CLAIM_email,email)
        //.withClaim(CLAIM_role,role)
        .sign(algorithm)

    companion object {
        private const val ISSUER = "Authentication"
        private const val AUDIENCE = "Land Auto User"
        const val CLAIM_id = "id"
        const val CLAIM_name = "name"
        const val CLAIM_email = "email"
        const val CLAIM_role = "role"


        lateinit var instance: JWTConfiguration
            private set

        fun initialize(secret: String) {
            synchronized(this) {
                if (!this::instance.isInitialized) {
                    instance = JWTConfiguration(secret)
                }
            }
        }
   }
}