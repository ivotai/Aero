package com.sanre.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import com.sanre.R
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
    }

    @Inject
    lateinit var retrofit1: Retrofit

    @Inject
    lateinit var retrofit2: Retrofit

    private fun login() {
        val username = "13611840424"
        val password = "111111"
            Logger.e(retrofit1.toString())
        Logger.e(retrofit2.toString())
//        simpleApi.login(username = username, password = password)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object :SingleObserver<LoginResponse>{
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