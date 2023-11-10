package com.bellonee.tables

import java.time.LocalDateTime
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object UserTable: Table("users") {
    val id = integer("id").autoIncrement()
    val fullName = varchar("full_name", length = 256)
    val email = text("email")
    val password = text("password")
    val address = text("address")
    val phoneNumber = text("phone_number")
    val createAt = datetime("createAt").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)
}