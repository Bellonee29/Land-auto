package com.bellonee.dto.request

data class VehicleRegistrationRequest (
    val vehicleType: String,
    val industryModelCode: String,
    val engineNumber: String,
    val engineType: String,
    val fuelType: String,
    val numberOfSeats: Int,
    val acFitted: String,
    val colour:String,
    val bodyType: String,
    val vehicleYear: String,
    val models: String,
    val series: String,
    val marketPrice: Int,
    val displaysSupported: String,
)
