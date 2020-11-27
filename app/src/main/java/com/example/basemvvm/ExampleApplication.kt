package com.example.basemvvm

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.basemvvm.data.source.repository.HolidayCardRepository
import com.example.basemvvm.data.source.repository.LanguageRepository
import timber.log.Timber

class ExampleApplication : Application(){

    val languageRepository: LanguageRepository
        get() = ServiceLocator.provideLanguageRepository(this)
    val holidayCarRepository: HolidayCardRepository
        get() = ServiceLocator.provideHolidayCardRepository(this)

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    //For Mutidex implementation for Android prior 5.0
//    override fun attachBaseContext(base: Context?) {
//        super.attachBaseContext(base)
//        MultiDex.install(this)
//    }
}