package com.bellonee.tables

import com.bellonee.enums.Role
import java.time.LocalDateTime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object UserTable: Table("users") {
    val id = integer("id").autoIncrement()
    val fullName = varchar("full_name", length = 256)
    val userName = varchar("user_name", length = 256)
    val email = text("email")
    val password = text("password")
    val role = varchar("role", length = 50)//enumerationByName("role", 10, Role::class)//Role.CUSTOMER
    val address = text("address")
    val phoneNumber = text("phone_number")
    val createAt = datetime("createAt").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)
}