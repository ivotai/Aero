package com.sanre.ui

import com.sanre.R
import com.sanre.app.Param
import com.sanre.ui.base.BaseFra
import kotlinx.android.synthetic.main.fra_text.*

class TextFra : BaseFra(R.layout.fra_text) {

    override fun initViews() {
        tvText.text = text
    }

    private val text by lazy { arguments?.getString(Param) }

}