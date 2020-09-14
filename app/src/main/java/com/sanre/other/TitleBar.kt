package com.sanre.other

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.blankj.utilcode.util.ActivityUtils
import com.sanre.R
import com.sanre.app.safeClicks
import kotlinx.android.synthetic.main.title_bar.view.*

class TitleBar(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs){

    init {
        LayoutInflater.from(context).inflate(R.layout.title_bar, this)

        tvOperation.visibility = View.INVISIBLE

        iivBack.safeClicks().subscribe {
            ActivityUtils.getTopActivity().finish()
        }
    }

    fun setTitle(title: String, allowBack: Boolean = true) {
        tvTitle.text = title
        iivBack.visibility = if (allowBack) View.VISIBLE else View.INVISIBLE
    }

    fun setOperation(operation: String) = tvOperation.apply {
        text = operation
        visibility = View.VISIBLE
    }

}