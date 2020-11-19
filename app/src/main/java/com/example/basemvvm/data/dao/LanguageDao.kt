package com.example.basemvvm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basemvvm.data.model.Language

@Dao
interface LanguageDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateLanguage(language: Language)

    @Query("SELECT * FROM language LIMIT 1")
    fun getLanguage(): Language
}