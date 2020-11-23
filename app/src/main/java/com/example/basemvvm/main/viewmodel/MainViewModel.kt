package com.example.basemvvm.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.basemvvm.ServiceLocator

class MainViewModel : ViewModel(){

    private var lang = ""

    init {
        lang = ServiceLocator.getLanguage()
    }
}