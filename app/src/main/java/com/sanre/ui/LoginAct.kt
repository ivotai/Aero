package com.sanre.ui

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding4.view.clicks
import com.rxjava.rxlife.life
import com.sanre.R
import com.sanre.app.di.ComponentHolder
import com.sanre.data.api.SimpleApi
import com.sanre.data.model.LoginResponse
import com.tbruyelle.rxpermissions3.RxPermissions
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.act_login.*

class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)
//        login()
//        requestPer()

        btnLogin.clicks().subscribe {
            login()
        }
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

    private fun requestPer() {
        RxPermissions(this)
            .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe { granted ->
                if (granted) { // Always true pre-M
                    // I can control the camera now
                } else {
                    finish()
                }
            }
    }

}