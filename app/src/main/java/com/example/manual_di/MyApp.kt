package com.example.manual_di

import android.app.Application
import com.example.manual_di.di.AppModule
import com.example.manual_di.di.AppModuleImpl
import dagger.hilt.android.HiltAndroidApp

class MyApp: Application() {

    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}


//@HiltAndroidApp
//class MyApp: Application()