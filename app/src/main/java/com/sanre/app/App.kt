package com.sanre.app

import androidx.multidex.MultiDexApplication
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.sanre.app.di.ComponentHolder

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
        ComponentHolder.init(this)
    }

}