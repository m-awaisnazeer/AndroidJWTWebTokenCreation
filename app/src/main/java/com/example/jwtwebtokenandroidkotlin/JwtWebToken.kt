package com.example.jwtwebtokenandroidkotlin

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*

fun main() {
    print(getToken())
}

fun getToken(): String? {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_WEEK, 7)

    val secretKey = "test_secret_key_for_jwt_web_token"

    return Jwts.builder()
        .setIssuer("myTestApp")
        .setIssuedAt(Date())
        .setExpiration(calendar.time)
        .signWith(Keys.hmacShaKeyFor(secretKey.toByteArray()), SignatureAlgorithm.HS256).compact()
}