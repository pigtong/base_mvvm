package com.example.basemvvm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basemvvm.data.dao.LanguageDao
import com.example.basemvvm.data.model.Language

@Database(entities = [Language::class], version = 1, exportSchema = false)
abstract class ExampleDatabase : RoomDatabase(){

    abstract fun languageDao(): LanguageDao
}