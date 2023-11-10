package com.bellonee.repository

import com.bellonee.utils.BaseResponse

interface VehicleRegistrationRepository {
    suspend fun registerVehicle (vehicleRegistrationRepository: VehicleRegistrationRepository): BaseResponse<Any>
}