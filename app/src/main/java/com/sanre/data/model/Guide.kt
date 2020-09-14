package com.sanre.data.model

import com.sanre.ui.guide.GuideAct

enum class Guide(val cn: String, val cls: Class<*>) {
    GuideSelf(cn = "导航", cls = GuideAct::class.java)
    ;

    companion object {
        val all get() = listOf(GuideSelf)
    }
}