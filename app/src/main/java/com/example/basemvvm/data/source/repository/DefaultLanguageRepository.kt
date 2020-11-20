package com.example.basemvvm.data.source.repository

import com.example.basemvvm.data.Result
import com.example.basemvvm.data.model.Language
import com.example.basemvvm.data.source.LanguageDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class DefaultLanguageRepository (
    private val languageDataSource: LanguageDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : LanguageRepository{

    override suspend fun saveLanguage(language: Language) {
        withContext(ioDispatcher){
            coroutineScope { languageDataSource.saveLanguage(language) }
        }
    }

    override suspend fun getLanguage(): Result<Language> {
        return languageDataSource.getLanguage()
    }
}