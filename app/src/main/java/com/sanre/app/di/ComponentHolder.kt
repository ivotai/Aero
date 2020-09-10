package com.sanre.app.di

import android.app.Application
import com.sanre.app.di.component.AppComponent
import com.sanre.app.di.component.DaggerAppComponent

object ComponentHolder {

    lateinit var appComponent: AppComponent

    fun init(application: Application) {
        appComponent = DaggerAppComponent.create()
    }

}