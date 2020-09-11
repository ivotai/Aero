package com.sanre.ui

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import com.sanre.R
import com.sanre.app.di.ComponentHolder
import com.sanre.data.api.SimpleApi
import com.tbruyelle.rxpermissions3.RxPermissions

class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        login()
//        requestPer()
    }

    lateinit var simpleApi: SimpleApi

    private fun login() {
        val username = "13611840424"
        val password = "111111"

//        simpleApi.login(username = username, password = password)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .life(this)
//            .subscribe(object : SingleObserver<LoginResponse> {
//                override fun onSubscribe(d: Disposable?) {
//                }
//
//                override fun onSuccess(t: LoginResponse?) {
//
//                }
//
//                override fun onError(e: Throwable?) {
//                }
//            })
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