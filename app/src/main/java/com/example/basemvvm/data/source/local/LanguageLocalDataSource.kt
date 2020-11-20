package com.example.basemvvm.data.source.local

import com.example.basemvvm.data.Result
import com.example.basemvvm.data.Result.Success
import com.example.basemvvm.data.Result.Error
import com.example.basemvvm.data.dao.LanguageDao
import com.example.basemvvm.data.model.Language
import com.example.basemvvm.data.source.LanguageDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LanguageLocalDataSource (
    private val languageDao: LanguageDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : LanguageDataSource {

    override suspend fun saveLanguage(language: Language) {
        languageDao.insertOrUpdateLanguage(language)
    }

    override suspend fun getLanguage(): Result<Language> {
        return withContext(ioDispatcher) {
            try {
                Success(languageDao.getLanguage())
            } catch (e: Exception) {
                Error(e)
            }
        }
    }
}