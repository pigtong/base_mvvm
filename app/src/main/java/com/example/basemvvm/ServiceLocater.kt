package com.example.basemvvm

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import com.example.basemvvm.data.ExampleDatabase
import com.example.basemvvm.data.source.HolidayCardDataSource
import com.example.basemvvm.data.source.LanguageDataSource
import com.example.basemvvm.data.source.local.LanguageLocalDataSource
import com.example.basemvvm.data.source.remote.ExampleApiService
import com.example.basemvvm.data.source.remote.HolidayCardRemoteDataSource
import com.example.basemvvm.data.source.repository.HolidayCardRepository
import com.example.basemvvm.data.source.repository.HolidayCardRepositoryImpl
import com.example.basemvvm.data.source.repository.LanguageRepositoryImpl
import com.example.basemvvm.data.source.repository.LanguageRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {

    const val DB_NAME = "example_database"

    private var database: ExampleDatabase? = null
    private var apiService: ExampleApiService? = null
    private var lang: String = "en"

    @Volatile
    var languageRepository: LanguageRepository? = null
        @VisibleForTesting set
    var holidayCardRepository: HolidayCardRepository? = null
        @VisibleForTesting set

    fun provideLanguageRepository(context: Context): LanguageRepository {
        synchronized(this) {
            return languageRepository ?: languageRepository ?: createLanguageRepository(context)
        }
    }

    private fun createLanguageRepository(context: Context): LanguageRepository {
        val newRepo =
            LanguageRepositoryImpl(
                createLanguageLocalDataSource(context)
            )
        languageRepository = newRepo
        return newRepo
    }

    private fun createLanguageLocalDataSource(context: Context): LanguageDataSource {
        val database = database ?: createDataBase(context)
        return LanguageLocalDataSource(database.languageDao())
    }

    fun provideHolidayCardRepository(context: Context): HolidayCardRepository {
        synchronized(this) {
            return holidayCardRepository ?: holidayCardRepository ?: createHolidayCardRepository()
        }
    }

    private fun createHolidayCardRepository(): HolidayCardRepository {
        val newRepo = HolidayCardRepositoryImpl(createHolidayCardRemoteDataSource())
        holidayCardRepository = newRepo
        return newRepo
    }

    private fun createHolidayCardRemoteDataSource(): HolidayCardDataSource {
        val apiService = apiService ?: createApiService()
        return HolidayCardRemoteDataSource(apiService)
    }

    private fun createApiService(): ExampleApiService {
        val interceptor = HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.HEADERS
            }
        }

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.DOMAIN)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ExampleApiService::class.java)
    }

    private fun createDataBase(context: Context): ExampleDatabase {
        val result = Room.databaseBuilder(
            context.applicationContext,
            ExampleDatabase::class.java, DB_NAME
        ).build()
        database = result
        return result
    }

    fun getLanguage() = lang

    fun setLanguage(_lang: String){
        lang = _lang
    }
}