package com.example.basemvvm.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basemvvm.data.model.HolidayCard

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<HolidayCard>?) {
    items?.let {
        (listView.adapter as HolidayCardAdapter).submitList(items)
    }
}