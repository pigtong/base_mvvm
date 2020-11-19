package com.example.basemvvm

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import timber.log.Timber

class TestApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}