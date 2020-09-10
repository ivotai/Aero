package com.sanre.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import com.rxjava.rxlife.life
import com.sanre.R
import com.sanre.app.di.ComponentHolder
import com.sanre.data.api.SimpleApi
import retrofit2.Retrofit
import javax.inject.Inject

class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
    }

    lateinit var simpleApi:SimpleApi

    private fun login() {
        val username = "13611840424"
        val password = "111111"
        Logger.e(ComponentHolder.appComponent.api().toString())
        Logger.e(ComponentHolder.appComponent.api().toString())

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

}