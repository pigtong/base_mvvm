package com.example.basemvvm

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import com.example.basemvvm.data.ExampleDatabase
import com.example.basemvvm.data.source.LanguageDataSource
import com.example.basemvvm.data.source.local.LanguageLocalDataSource
import com.example.basemvvm.data.source.repository.DefaultLanguageRepository
import com.example.basemvvm.data.source.repository.LanguageRepository

object ServiceLocator {

    const val DB_NAME = "example_database"

    private var database: ExampleDatabase? = null
    private var accessToken: String = ""
    private var lang: String = ""

    @Volatile
    var languageRepository: LanguageRepository? = null
        @VisibleForTesting set

    fun provideLanguageRepository(context: Context): LanguageRepository {
        synchronized(this) {
            return languageRepository ?: languageRepository ?: createLanguageRepository(context)
        }
    }

    private fun createLanguageRepository(context: Context): LanguageRepository {
        val newRepo =
            DefaultLanguageRepository(
                createLanguageLocalDataSource(context)
            )
        languageRepository = newRepo
        return newRepo
    }

    private fun createLanguageLocalDataSource(context: Context): LanguageDataSource {
        val database = database ?: createDataBase(context)
        return LanguageLocalDataSource(database.languageDao())
    }

    private fun createDataBase(context: Context): ExampleDatabase {
        val result = Room.databaseBuilder(
            context.applicationContext,
            ExampleDatabase::class.java, DB_NAME
        ).build()
        database = result
        return result
    }

    fun getLanguage(): String{
        return if(lang.isNullOrEmpty())
            "en"
        else lang
    }

    fun setLanguage(_lang: String){
        lang = _lang
    }
}