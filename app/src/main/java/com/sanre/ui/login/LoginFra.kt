package com.sanre.ui.login

import com.jakewharton.rxbinding4.view.clicks
import com.sanre.R
import com.sanre.app.Globals.logined
import com.sanre.app.di.ComponentHolder
import com.sanre.app.helper.MaskHelper.hideMask
import com.sanre.app.helper.MaskHelper.showMask
import com.sanre.ui.base.BaseFra
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fra_login.*
import java.util.concurrent.TimeUnit

class LoginFra : BaseFra(R.layout.fra_login) {

    override fun initViews() {
        titleBar.setTitle(title = "登录", allowBack = false)
    }

    override fun initBindings() {
        btnLogin.clicks().subscribe { login() }
    }

    private val username = "13611840424"
    private val password = "111111"

    private fun login() {
        showMask(context)
        ComponentHolder.appComponent.api().login(username = username, password = password)
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    hideMask()
                    logined = true
                },
                onError = {
                    hideMask()
                }
            )
    }

}