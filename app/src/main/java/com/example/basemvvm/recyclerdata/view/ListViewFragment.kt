package com.example.basemvvm.recyclerdata.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.basemvvm.adapter.HolidayCardAdapter
import com.example.basemvvm.databinding.ListviewFragmentBinding
import com.example.basemvvm.recyclerdata.viewmodel.RecyclerDataViewModel
import com.example.basemvvm.utils.getViewModelFactory

class ListViewFragment : Fragment() {

    private lateinit var viewDataBinding : ListviewFragmentBinding
    private lateinit var listAdapter : HolidayCardAdapter
    private val recyclerDataViewModel by activityViewModels<RecyclerDataViewModel> { getViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = ListviewFragmentBinding.inflate(layoutInflater).apply {
            recyclerdataviewmodel = recyclerDataViewModel
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        setupView()
        setupAdapter()
    }

    private fun setupView(){

    }

    private fun setupAdapter(){
        listAdapter = HolidayCardAdapter()
        viewDataBinding.holidayCardRecyclerView.adapter = listAdapter
    }
}