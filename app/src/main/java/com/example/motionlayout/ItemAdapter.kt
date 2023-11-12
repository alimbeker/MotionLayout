package com.example.motionlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayout.databinding.ItemDesignBinding


class ItemAdapter(private val data: List<MyItem>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    var itemClick: ((MyItem,FragmentNavigator.Extras) -> Unit)? = null



    inner class MyViewHolder(val binding: ItemDesignBinding, val itemClick: ((MyItem,FragmentNavigator.Extras) -> Unit)?) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem) {
            binding.image.setImageResource(item.imageResId)
            binding.title.text = item.text


            binding.image.transitionName = item.imageResId.toString()
            binding.title.transitionName = item.text
            
            itemView.setOnClickListener {
                val extras = FragmentNavigatorExtras(
                    binding.image to "imageResId",
                    binding.title to "text"
                )
                itemClick?.invoke(item,extras)
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
