package com.sanre.app.helper

import android.content.Context
import com.kaopiz.kprogresshud.KProgressHUD

object MaskHelper {

    private var mask: KProgressHUD? = null

    fun showMask(context: Context?) {
        mask = KProgressHUD.create(context)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(false)
//            .setAnimationSpeed(2)
            .setDimAmount(0.5f)
            .show()
    }

    fun hideMask() {
        mask?.dismiss()
        mask = null
    }

}