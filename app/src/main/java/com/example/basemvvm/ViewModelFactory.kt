package com.example.basemvvm

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.basemvvm.data.source.repository.HolidayCardRepository
import com.example.basemvvm.data.source.repository.LanguageRepository
import com.example.basemvvm.main.viewmodel.MainViewModel
import com.example.basemvvm.recyclerdata.viewmodel.RecyclerDataViewModel
import com.example.basemvvm.security.viewmodel.SecurityViewModel
import com.example.basemvvm.setting.viewmodel.SettingViewModel

class ViewModelFactory constructor(
    private val languageRepository: LanguageRepository,
    private val holidayCardRepository: HolidayCardRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs){

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass){
        when {
            isAssignableFrom(MainViewModel::class.java) -> MainViewModel()
            isAssignableFrom(RecyclerDataViewModel::class.java) -> RecyclerDataViewModel(holidayCardRepository)
            isAssignableFrom(SettingViewModel::class.java) -> SettingViewModel(languageRepository)
            isAssignableFrom(SecurityViewModel::class.java) -> SecurityViewModel()
          else ->
              throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}