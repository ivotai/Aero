package com.sanre.data.model

data class LoginResponse(
    val loginToken: String,
    val session: String,
    val success: Boolean,
    val user: User,
    val message: String
)

data class User(
    val id: Long,
    val roleTag: String,
    val roles: List<String>,
    val username: String,
    val courtName: String
)