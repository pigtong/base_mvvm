package com.example.basemvvm.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.basemvvm.databinding.MainFragmentBinding
import com.example.basemvvm.main.viewmodel.MainViewModel
import com.example.basemvvm.utils.getViewModelFactory
import timber.log.Timber

class MainFragment : Fragment(){

    private lateinit var viewBinding : MainFragmentBinding
    private val mainViewModel by activityViewModels<MainViewModel> { getViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = MainFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView()
    }

    private fun setupView(){

    }
}