package com.sanre.app.di.module

import com.sanre.data.api.SimpleApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object ApiModule {

    @Provides
    fun provideSimpleApi(retrofit: Retrofit): SimpleApi = retrofit.create(SimpleApi::class.java)

}