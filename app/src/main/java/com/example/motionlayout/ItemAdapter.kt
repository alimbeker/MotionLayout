package com.example.motionlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayout.databinding.ItemDesignBinding


class ItemAdapter(private val data: List<MyItem>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    var itemClick: ((MyItem) -> Unit)? = null

    inner class MyViewHolder(val binding: ItemDesignBinding, val itemClick: ((MyItem) -> Unit)?) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem) {
            binding.cardImage.setImageResource(item.imageResId)
            binding.cardText.text = item.text

            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding, itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
