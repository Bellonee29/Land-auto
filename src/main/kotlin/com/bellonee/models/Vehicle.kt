package com.bellonee.models

import kotlin.random.Random
import kotlinx.serialization.Serializable


@Serializable
data class Vehicle (
    val id: Int,
    val vehicleType: String,
    val industryModelCode: String,
    val engineNumber: String, // inline value class
    val engineType: String, // make as enum type
    val fuelType: String, // Make as enum type
    val firstRegistrationDate: String, // convert to date format
    val numberOfSeats: Int,
    val acFitted: String,
    val colour:String,
    val bodyType: String,
    val vehicleYear: String,
    val models: String,
    val series: String,
    val marketPrice: Int, // this should be Double
    val displaySupported: String,
) {

}