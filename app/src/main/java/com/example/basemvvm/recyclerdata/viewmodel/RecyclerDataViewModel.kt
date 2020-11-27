package com.example.basemvvm.recyclerdata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecyclerDataViewModel : ViewModel(){

    private val _dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val dataLoading : LiveData<Boolean> = _dataLoading
}