package com.example.basemvvm.data.source

import com.example.basemvvm.data.Result
import com.example.basemvvm.data.model.Language

interface LanguageDataSource {

    //local
    suspend fun saveLanguage(language: Language)

    //local
    suspend fun getLanguage(): Result<Language>
}