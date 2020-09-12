package com.sanre.app

import androidx.multidex.MultiDexApplication
import com.mikepenz.iconics.Iconics
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.sanre.app.di.ComponentHolder
import com.sanre.other.icon.Fad
import com.sanre.other.icon.Fal
import com.sanre.other.icon.Far

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        Logger.addLogAdapter(AndroidLogAdapter())
        ComponentHolder.init(this)
        initIconics()
    }

    private fun initIconics() {
        Iconics.init(applicationContext)
        Iconics.registerFont(Fal)
        Iconics.registerFont(Fad)
        Iconics.registerFont(Far)
    }

}