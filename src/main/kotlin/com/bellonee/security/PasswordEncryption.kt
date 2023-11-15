package com.bellonee.security

import com.bellonee.models.User
import io.ktor.util.hex
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

//private val SECRET_KEY = "43256546"
//private val ALGORITHM = "HMacSHA1"
//private val HASH_KEY = hex(SECRET_KEY)
//private val HMAC_KEY = SecretKeySpec(HASH_KEY, ALGORITHM)
//
//fun hash(password: String): String {
//    val hmac = Mac.getInstance(ALGORITHM)
//    hmac.init(HMAC_KEY)
//    return hex(hmac.doFinal(password.toByteArray(Charsets.UTF_8)))
//}

private val SECRET_KEY = "43256546"
private val ALGORITHM = "HmacSHA1"
private val HMAC_KEY = SecretKeySpec(hex(SECRET_KEY), ALGORITHM)

private fun hex(bytes: ByteArray): String {
    val hexArray = "0123456789ABCDEF".toCharArray()
    val hexChars = CharArray(bytes.size * 2)
    for (i in bytes.indices) {
        val v = bytes[i].toInt() and 0xFF
        hexChars[i * 2] = hexArray[v ushr 4]
        hexChars[i * 2 + 1] = hexArray[v and 0x0F]
    }
    return String(hexChars)
}

fun hash(password: String): String {
    val hmac = Mac.getInstance(ALGORITHM)
    hmac.init(HMAC_KEY)
    return hex(hmac.doFinal(password.toByteArray(Charsets.UTF_8)))
}

