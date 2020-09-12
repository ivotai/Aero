package com.sanre.app

import androidx.multidex.MultiDexApplication
import com.mikepenz.iconics.Iconics
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.sanre.app.di.ComponentHolder

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
        ComponentHolder.init(this)
        Iconics.init(applicationContext)
        Iconics.registerFont(com.sanre.icon.Fal)
    }

}