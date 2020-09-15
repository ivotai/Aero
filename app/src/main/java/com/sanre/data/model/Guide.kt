package com.sanre.data.model

import com.sanre.ui.login.LoginAct
import com.sanre.ui.viewPager2.example1.ViewPager21Act

enum class Guide(val cn: String, val cls: Class<*>) {

    ViewPager21(cn = "ViewPager2 用例1", cls = ViewPager21Act::class.java),
    Logout(cn = "退出", cls = LoginAct::class.java),
    ;

    companion object {
        val all get() = mutableListOf(ViewPager21, Logout)
    }

}