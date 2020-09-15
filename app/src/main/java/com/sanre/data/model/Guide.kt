package com.sanre.data.model

import com.sanre.ui.general.BottomTabStripAct
import com.sanre.ui.login.LoginAct

enum class Guide(val cn: String, val cls: Class<*>) {
    Logout(cn = "退出", cls = LoginAct::class.java),
    ViewPager21(cn = "ViewPager2 用例1", cls = BottomTabStripAct::class.java)
    ;

    companion object {
        val all get() = mutableListOf(ViewPager21, Logout)
    }
}