package com.bellonee.tables

import org.jetbrains.exposed.sql.Table

object AdminTable: Table("Admin") {
    val id = integer("id").autoIncrement()
    val fulName = varchar("full_name", length = 256)
    val email = varchar("email", length = 256)
    val password = varchar("password", length = 256)

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)


}