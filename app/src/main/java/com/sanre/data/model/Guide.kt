package com.sanre.data.model

import com.sanre.ui.login.LoginAct

enum class Guide(val cn: String, val cls: Class<*>) {
    Logout(cn = "退出", cls = LoginAct::class.java)
    ;

    companion object {
        val all get() = mutableListOf(Logout)
    }
}