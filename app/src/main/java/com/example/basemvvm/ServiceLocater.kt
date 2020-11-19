package com.example.basemvvm

object ServiceLocator {

    const val DB_NAME = "test_database"

    private var accessToken: String = ""
    private var lang: String = ""

    fun getLanguage(): String{
        return if(lang.isNullOrEmpty())
            "en"
        else lang
    }

    fun setLanguage(_lang: String){
        lang = _lang
    }
}