package com.bellonee.security

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.jwt.jwt

fun Application.configureSecurity() {
    JWTConfiguration.initialize("registerloginauth")
    install(Authentication){
        jwt {
            verifier(JWTConfiguration.instance.verifier)
            validate {
                val claimId = it.payload.getClaim(JWTConfiguration.CLAIM_id).asInt()
                val claimName = it.payload.getClaim(JWTConfiguration.CLAIM_name).asString()
                val claimEmail = it.payload.getClaim(JWTConfiguration.CLAIM_email).asString()
                if (claimId != null || claimName != null || claimEmail != null){
                    UserPrincipal(claimId, claimName, claimEmail)
                   // UserIdPrincipalForUser()
                }else{
                    null
                }
            }
        }
    }
}