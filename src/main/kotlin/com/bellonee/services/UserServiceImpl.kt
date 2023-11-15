package com.bellonee.services

import com.bellonee.database.DatabaseServices.dbQuery
import com.bellonee.dto.request.LoginRequest
import com.bellonee.dto.request.UserRequest
import com.bellonee.models.User
import com.bellonee.security.hash
import com.bellonee.tables.UserTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement

class UserServiceImpl : UserService {
    override suspend fun registerUser(userRequest: UserRequest): User? {
        var statement: InsertStatement<Number>? = null
        dbQuery{
            statement = UserTable.insert {
                it[fullName] = userRequest.fullName
                it[email] = userRequest.email
                it[password] = hash(userRequest.password)
                it[address] = userRequest.address
                it[phoneNumber] = userRequest.phoneNumber
            }
        }
        return rowToUser(statement?.resultedValues?.get(0))
    }
    private fun rowToUser(row: ResultRow?):User?{
        return if(row == null) null
        else User(
            id = row[UserTable.id],
            fullName = row[UserTable.fullName],
            email = row[UserTable.email],
            address = row[UserTable.address],
            phoneNumber = row[UserTable.phoneNumber],
            createAt = row[UserTable.createAt].toString(),
        )

    }

//    override suspend fun loginUser(loginRequest: LoginRequest) {
//        TODO("Not yet implemented")
//    }

    override suspend fun findUserByEmail(email: String): User? {
        val user = dbQuery {
            UserTable.select{ UserTable.email.eq(email) }
                .map { rowToUser(it) }.singleOrNull()
        }
        return user
    }

//    override suspend fun findAllUser(): List<User> {
//        TODO("Not yet implemented")
//    }
}