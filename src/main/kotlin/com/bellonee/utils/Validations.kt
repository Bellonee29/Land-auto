package com.bellonee.utils

import com.bellonee.dto.request.UserRequest
import com.bellonee.execptions.BadRequestException
import org.koin.core.component.KoinComponent

abstract class BaseController : KoinComponent {
    internal fun validateRegisterFieldsOrThrowException(
        userRequest: UserRequest
    ) {
        val message = when {
            (userRequest.email.isBlank() or (userRequest.userName.isBlank()) or (userRequest.password.isBlank()) or (userRequest.confirmPassword.isBlank()) or (userRequest.fullName.isBlank()) or(userRequest.phoneNumber.isBlank())) -> "Fields should not be blank"
            (!userRequest.email.isEmailValid()) -> "Email invalid"
            (!userRequest.userName.isAlphaNumeric()) -> "No special characters allowed in username"
            (userRequest.userName.length !in (4..30)) -> "Username should be of min 4 and max 30 character in length"
            (userRequest.fullName.length !in (4..50)) -> "Full name should be of min 4 and max 50 character in length"
            (userRequest.phoneNumber.length !in (10..15)) -> "Phone number should be of min 10 and max 15 character in length"
            (userRequest.password.length !in (8..50)) -> "Password should be of min 8 and max 50 character in length"
            (userRequest.confirmPassword.length !in (8..50)) -> "Password should be of min 8 and max 50 character in length"
            (userRequest.password != userRequest.confirmPassword) -> "Passwords do not match"
            else -> return
        }

        throw BadRequestException(message)
    }

}
