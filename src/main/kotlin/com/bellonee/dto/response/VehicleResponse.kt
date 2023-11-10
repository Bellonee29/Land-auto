package com.bellonee.dto.response

data class VehicleResponse (
    val id: Int,
    val vehicleType: String,
    val industryModelCode: String,
    val engineNumber: String,
    val engineType: String,
    val fuelType: String,
    val firstRegistrationDate: String,
    val numberOfSeats: Int,
    val acFitted: String,
    val colour:String,
    val bodyType: String,
    val vehicleYear: String,
    val model: String,
    val series: String,
    val marketPrice: Int,
    val displaysSupported: String,
)