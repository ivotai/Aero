package com.sanre.ui.login

import com.jakewharton.rxbinding4.view.clicks
import com.sanre.R
import com.sanre.app.di.ComponentHolder
import com.sanre.ui.base.BaseFra
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fra_login.*

class LoginFra : BaseFra(R.layout.fra_login) {

    override fun initBindings() {
        btnLogin.clicks().subscribe { login() }
    }

    private fun login() {
        val username = "13611840424"
        val password = "111111"

        ComponentHolder.appComponent.api().login(username = username, password = password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {},
                onError = {}
            )
    }

}