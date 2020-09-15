package com.sanre.data.api

import com.sanre.app.Globals
import com.sanre.data.model.Article
import com.sanre.data.model.LoginResponse
import com.sanre.data.model.Page
import com.sanre.data.model.Response
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("login/account")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Single<LoginResponse>

    @GET("login/silence")
    fun loginSilently(@Query("token") token: String = Globals.loginToken): Call<LoginResponse>

    @GET("api/v1/app/article")
    fun getArticle(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("category") category: String?,
        @Query("keyword") keyword: String = ""
    ): Single<Response<Page<Article>>>

}