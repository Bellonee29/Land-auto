package com.bellonee.utils

import kotlin.random.Random

fun generateRandomNumber(): Int {
    val random = Random
    return random.nextInt(53435)
}