package com.example.basemvvm.recyclerdata.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.basemvvm.R
import com.example.basemvvm.databinding.RecyclerdataFragmentBinding
import com.example.basemvvm.main.view.MainActivity
import com.example.basemvvm.recyclerdata.viewmodel.RecyclerDataViewModel
import com.example.basemvvm.utils.getViewModelFactory

class RecyclerDataFragment : Fragment() {

    private lateinit var viewBinding : RecyclerdataFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = RecyclerdataFragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView()
    }

    private fun setupView(){
        findNavController()?.navigate(R.id.listview_frag_dest)
    }
}