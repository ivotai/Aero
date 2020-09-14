package com.sanre.data.model

import com.sanre.ui.guide.GuideAct
import com.sanre.ui.login.LoginAct

enum class Guide(val cn: String, val cls: Class<*>) {
    GuideSelf(cn = "导航", cls = GuideAct::class.java),
    Logout(cn = "返回登录界面", cls = LoginAct::class.java)
    ;

    companion object {
        val all get() = mutableListOf(GuideSelf, Logout)
    }
}