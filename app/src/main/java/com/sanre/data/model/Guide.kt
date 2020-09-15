package com.sanre.data.model

import com.sanre.ui.login.LoginAct
import com.sanre.ui.vp2.example1.ViewPager2Example1Act

enum class Guide(val cn: String, val cls: Class<*>) {

    ViewPager21(cn = "ViewPager2 用例", cls = ViewPager2Example1Act::class.java),
    Logout(cn = "退出登录", cls = LoginAct::class.java),
    ;

    companion object {
        val all get() = mutableListOf(ViewPager21, Logout)
    }

}