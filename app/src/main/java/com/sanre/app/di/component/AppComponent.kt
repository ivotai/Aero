package com.sanre.app.di.component

import com.sanre.app.di.NetworkModule
import com.sanre.app.di.module.ApiModule
import com.sanre.data.api.SimpleApi
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApiModule::class])
interface AppComponent {

    fun api(): SimpleApi

}