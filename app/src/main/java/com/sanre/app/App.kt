package com.sanre.app

import androidx.multidex.MultiDexApplication
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp(MultiDexApplication::class)
class App : Hilt_App() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }

}