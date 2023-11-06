package com.example.motionlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayout.databinding.ItemDesignBinding


class ItemAdapter(private val data: List<MyItem>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem) {
            binding.cardImage.setImageResource(item.imageResId)
            binding.cardText.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
