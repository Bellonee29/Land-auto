package com.bellonee.routes

import com.bellonee.dto.request.UserRequest
import com.bellonee.repository.UserRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRoutes(repository: UserRepository){
    routing {
        route("/auth"){
            post("/register") {
                val params = call.receive<UserRequest>()
                val result = repository.registerUser(params)
                call.respond(result.statusCode, result)
            }
        }
    }

}