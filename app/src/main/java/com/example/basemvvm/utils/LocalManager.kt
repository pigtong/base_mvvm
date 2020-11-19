package com.example.basemvvm.utils

import android.content.Context
import android.content.res.Configuration
import com.example.basemvvm.ServiceLocator
import java.util.*

object LocaleManager{

    fun setLocale(context: Context): Context {
        return updateLanguage(context, ServiceLocator.getLanguage())
    }

    private fun updateLanguage(context: Context?, language: String?): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val config = Configuration(context!!.resources.configuration)
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }
}