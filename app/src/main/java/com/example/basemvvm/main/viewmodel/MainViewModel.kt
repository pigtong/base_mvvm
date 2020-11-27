package com.example.basemvvm.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basemvvm.ServiceLocator

class MainViewModel : ViewModel(){

    private val _testCount = MutableLiveData<Int>().apply { value = 0 }
    val testCount : LiveData<Int> = _testCount

    private var lang = ""

    init {
        lang = ServiceLocator.getLanguage()
    }

    fun updateCount(){
        _testCount.value = (_testCount.value?:0) + 1
    }
}