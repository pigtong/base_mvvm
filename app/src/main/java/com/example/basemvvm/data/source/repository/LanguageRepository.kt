package com.example.basemvvm.data.source.repository

import com.example.basemvvm.data.Result
import com.example.basemvvm.data.model.Language

interface LanguageRepository {

    //local
    suspend fun saveLanguage(language: Language)

    //local
    suspend fun getLanguage(): Result<Language>
}