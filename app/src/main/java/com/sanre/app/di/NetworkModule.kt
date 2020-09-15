package com.sanre.app.di

import com.sanre.app.baseUrl
import com.sanre.app.helper.NetworkHelper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                if ("login" in chain.request().url.encodedPathSegments)
                    chain.proceed(chain.request())
                else
                    NetworkHelper.proceedRequestWithSession(chain)
            }
            .addInterceptor { chain ->
                val response = chain.proceed(chain.request())
                if (response.code != 401) return@addInterceptor response
                // 401 表示 session 过期
                NetworkHelper.proceedRequestWithNewSession(chain)
            }

                .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}