package com.bellonee

import com.bellonee.database.DatabaseServices
import com.bellonee.repository.UserRepository
import com.bellonee.repository.UserRepositoryImpl
import com.bellonee.routes.userRoutes
import com.bellonee.services.UserService
import com.bellonee.services.UserServiceImpl
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseServices.init()
        install(ContentNegotiation){
            jackson ()
        }
    val service: UserService = UserServiceImpl()
    val repository: UserRepository = UserRepositoryImpl(service)
    userRoutes(repository)
}
