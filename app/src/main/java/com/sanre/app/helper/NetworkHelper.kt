package com.sanre.app.helper

import com.sanre.app.Cookie
import com.sanre.app.Globals
import com.sanre.app.SESSION
import com.sanre.app.di.ComponentHolder
import okhttp3.Interceptor
import okhttp3.Response

object NetworkHelper {

    fun proceedRequestWithNewSession(chain: Interceptor.Chain): Response {
        // session 过期时使用 token 登录，获取新的 session 和 token。
        api.loginSilently().execute().body().let { Globals.loginResponse = it!! }
        return proceedRequestWithSession(chain)
    }

    fun proceedRequestWithSession(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder()
            .removeHeader(Cookie)
            .addHeader(Cookie, "${SESSION}=${Globals.session}")
            .build()
            .let { chain.proceed(it) }
    }

    private val api by lazy { ComponentHolder.appComponent.api() }

}