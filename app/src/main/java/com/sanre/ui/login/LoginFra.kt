package com.sanre.ui.login

import com.jakewharton.rxbinding4.view.clicks
import com.rxjava.rxlife.life
import com.sanre.R
import com.sanre.app.Globals.loginResponse
import com.sanre.app.Globals.logined
import com.sanre.app.di.ComponentHolder
import com.sanre.app.helper.MaskHelper.hideMask
import com.sanre.app.helper.MaskHelper.showMask
import com.sanre.app.isEmpty
import com.sanre.app.startAct
import com.sanre.app.toast
import com.sanre.app.trimText
import com.sanre.data.model.UserInfo
import com.sanre.ui.base.BaseFra
import com.sanre.ui.guide.GuideAct
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fra_login.*
import java.util.concurrent.TimeUnit

class LoginFra : BaseFra(R.layout.fra_login) {

    override fun initViews() {
        restoreUserInfo()
    }

    private fun restoreUserInfo() {
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
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .life(this)
            .subscribe({
                hideMask()
                if (it.failed) return@subscribe
                "登录成功！".toast()
                logined = true
                storeUserInfo()
                loginResponse = it
                startAct(cls = GuideAct::class.java, finishSelf = true)
            }, {
                hideMask()
            })
    }

    private fun storeUserInfo() {
        UserInfo.username = etUsername.trimText()
        UserInfo.password = etPassword.trimText()
    }

}