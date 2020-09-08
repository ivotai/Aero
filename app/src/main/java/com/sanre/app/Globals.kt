package com.sanre.app

import com.sanre.data.model.LoginResponse
import com.sanre.data.model.User

object Globals {

    val session: String get() = loginResponse.session
    val loginToken: String get() = loginResponse.loginToken
    val user: User get() = loginResponse.user

    lateinit var loginResponse: LoginResponse

    var isLogout = false

}