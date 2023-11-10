package com.bellonee.tables

import org.jetbrains.exposed.sql.Table
import java.time.LocalDate
import org.jetbrains.exposed.sql.javatime.date


object VehicleTable: Table("vehicle") {
    val id = integer("id").autoIncrement()
    val vehicleType = text("vehicle_type")
    val industryModelCode = text("industry_model_code")
    val engineNumber = text("engine_number")
    val engineType = text("engine_type")
    val fuelType = text("fuel_type")
    val firstRegistrationDate = date("create_at").clientDefault { LocalDate.now() }
    val numberOfSeats = integer("number_of_seats")
    val acFitted = text("AC_fitted")
    val colour = text("colour")
    val bodyType = text("body_type")
    val vehicleYear = text("vehicle_year")
    val models = text("model")
    val series = text("series")
    val marketPrice = integer("market_price")
    val displaysSupported = text("displays_Supported")
}

