package com.sanre.app.di

import com.sanre.app.di.component.AppComponent
import com.sanre.app.di.component.DaggerAppComponent

object ComponentHolder {

    lateinit var appComponent: AppComponent

    fun init() {
        appComponent = DaggerAppComponent.create()
    }

}