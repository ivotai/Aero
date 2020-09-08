package com.sanre.data.api

import com.sanre.app.Globals
import com.sanre.data.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.*

interface SimpleApi {

    @GET("login/account")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Single<LoginResponse>

    @GET("login/silence")
    fun loginSilently(@Query("token") token: String = Globals.loginToken): Call<LoginResponse>

}