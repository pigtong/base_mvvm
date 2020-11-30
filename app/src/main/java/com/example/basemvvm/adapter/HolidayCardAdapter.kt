package com.example.basemvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basemvvm.adapter.HolidayCardAdapter.ViewHolder
import com.example.basemvvm.data.model.HolidayCard
import com.example.basemvvm.databinding.HolidaycardItemBinding

class HolidayCardAdapter : ListAdapter<HolidayCard, ViewHolder>(HolidayCardDiffCallBack()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: HolidaycardItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(holidayCard: HolidayCard){
            binding.apply {
                holidaycarditem = holidayCard
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HolidaycardItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class HolidayCardDiffCallBack : DiffUtil.ItemCallback<HolidayCard>() {
    override fun areItemsTheSame(oldItem: HolidayCard, newItem: HolidayCard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HolidayCard, newItem: HolidayCard): Boolean {
        return oldItem == newItem
    }
}