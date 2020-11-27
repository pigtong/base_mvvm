package com.example.basemvvm.setting.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.basemvvm.databinding.SettingFragmentBinding

class SettingFragment : Fragment(){

    private lateinit var viewBinding : SettingFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = SettingFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView()
    }

    private fun setupView(){

    }
}