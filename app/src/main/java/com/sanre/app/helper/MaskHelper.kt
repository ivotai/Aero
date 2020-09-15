package com.sanre.app.helper

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.blankj.utilcode.util.ColorUtils
import com.kaopiz.kprogresshud.KProgressHUD
import com.sanre.R

object MaskHelper {

    private var mask: KProgressHUD? = null

    fun showMask(context: Context?) {
        mask = KProgressHUD.create(context)
            .setBackgroundColor(ColorUtils.getColor(android.R.color.transparent))
            .setCustomView(loadingView(context))
            .setCancellable(false)
            .setDimAmount(0.6f)
            .show()
    }

    @SuppressLint("InflateParams")
    private fun loadingView(context: Context?): View {
        return LayoutInflater.from(context).inflate(R.layout.av_loading, null)
    }

    fun hideMask() {
        mask?.dismiss()
        mask = null
    }

}