package com.example.basemvvm.utils

import androidx.fragment.app.Fragment
import com.example.basemvvm.ExampleApplication
import com.example.basemvvm.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val languageRepository = (requireContext().applicationContext as ExampleApplication).languageRepository
    return ViewModelFactory(languageRepository, this)
}