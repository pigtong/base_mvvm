package com.example.basemvvm.security.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.basemvvm.databinding.SecurityFragmentBinding

class SecurityFragment : Fragment(){

    private lateinit var viewBinding : SecurityFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = SecurityFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView()
    }

    private fun setupView(){

    }
}