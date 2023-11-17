package com.bellonee.models

import com.bellonee.enums.EngineType
import com.bellonee.enums.VehicleType
import kotlinx.serialization.Serializable
import java.time.LocalDate


@Serializable
data class Vehicle (
    val id: Int,
    val vehicleType: VehicleType,
    val industryModelCode: String,
    val engineNumber: String, // inline value class
    val engineType: EngineType, // make as enum type
    val fuelType: String, // Make as enum type
    val firstRegistrationDate: LocalDate, // convert to date format
    val numberOfSeats: Int,
    val acFitted: String,
    val colour:String,
    val bodyType: String,
    val vehicleYear: String,
    val models: String,
    val series: String,
    val marketPrice: Double, // this should be Double
    val displaySupported: String,
) {

}