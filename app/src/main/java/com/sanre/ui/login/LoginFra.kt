package com.sanre.ui.login

import com.jakewharton.rxbinding4.view.clicks
import com.sanre.R
import com.sanre.app.Globals.logined
import com.sanre.app.di.ComponentHolder
import com.sanre.app.helper.MaskHelper.hideMask
import com.sanre.app.helper.MaskHelper.showMask
import com.sanre.app.isEmpty
import com.sanre.app.toast
import com.sanre.app.trimText
import com.sanre.data.model.UserInfo
import com.sanre.ui.base.BaseFra
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fra_login.*

class LoginFra : BaseFra(R.layout.fra_login) {

    override fun initViews() {
        etUsername.setText(UserInfo.username)
        etPassword.setText(UserInfo.password)
    }

    override fun initBindings() {
        btnLogin.clicks().subscribe { login() }

    }

    private fun login() {
        if (etUsername.isEmpty()) {
            "用户名不能为空".toast()
            return
        }
        if (etPassword.isEmpty()) {
            "密码不能为空".toast()
            return
        }

        showMask(context)
        ComponentHolder.appComponent.api()
            .login(username = etUsername.trimText(), password = etPassword.trimText())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    hideMask()
                    if (!it.success) {
                        it.message.toast()
                        return@subscribeBy
                    }
                    logined = true
                    UserInfo.username = etUsername.trimText()
                    UserInfo.password = etPassword.trimText()
                },
                onError = {
                    hideMask()
                }
            )
    }

}