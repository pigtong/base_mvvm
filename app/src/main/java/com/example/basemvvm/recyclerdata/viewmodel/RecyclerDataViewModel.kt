package com.example.basemvvm.recyclerdata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basemvvm.data.model.HolidayCard
import com.example.basemvvm.data.source.repository.HolidayCardRepository
import kotlinx.coroutines.launch

class RecyclerDataViewModel(
    private val holidayCardRepository: HolidayCardRepository
) : ViewModel(){

    private val _dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val dataLoading : LiveData<Boolean> = _dataLoading

    private val _holidayCardItems = MutableLiveData<List<HolidayCard>>().apply { value = emptyList() }
    val holidayCardItems : LiveData<List<HolidayCard>> = _holidayCardItems

    init {
        if(_holidayCardItems.value.isNullOrEmpty()) loadHolidayCards()
    }

    fun refreshHolidayCard(){
        loadHolidayCards()
    }

    private fun loadHolidayCards(){
        _dataLoading.value = true
        viewModelScope.launch {
            holidayCardRepository.getHolidayCards(
                { holidayCardItems ->
                    _holidayCardItems.value = holidayCardItems
                    _dataLoading.value = false
                },
                { errorMessage ->
                    _dataLoading.value = false
                })
        }
    }
}