package com.sanre.data.model

import com.sanre.ui.example1.Example1Act
import com.sanre.ui.login.LoginAct

enum class Guide(val cn: String, val cls: Class<*>) {

    Example1(cn = "PagerBottomTabStrip", cls = Example1Act::class.java),
    Logout(cn = "退出登录", cls = LoginAct::class.java),
    ;

    companion object {
        val all get() = mutableListOf(Example1, Logout)
    }

}