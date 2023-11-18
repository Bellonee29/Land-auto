package com.bellonee.database

import com.bellonee.tables.AdminTable
import com.bellonee.tables.UserTable
import com.bellonee.tables.VehicleTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseServices {
    fun init() {
        Database.connect(hikari())

        transaction {
            SchemaUtils.create(UserTable)
            SchemaUtils.create(AdminTable)
            SchemaUtils.create(VehicleTable)
        }
    }
    private fun hikari():HikariDataSource{
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = "jdbc:postgresql://localhost:5432/vehicle?user=postgres"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }
    suspend fun <T>dbQuery(block: () -> T): T = withContext(Dispatchers.IO){
        transaction {
            block()
        }
    }
}