package com.example.motionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.motionlayout.databinding.FragmentCardsBinding

class CardsFragment : Fragment() {
    private lateinit var binding : FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)

        val data = listOf(
            MyItem("Улица", R.drawable.street),
            MyItem("Реклама", R.drawable.time_square),
            MyItem("Статуя Свободы", R.drawable.liberty_state1),
            MyItem("Статуя Свободы", R.drawable.liberty_state2),
            MyItem("Песик", R.drawable.dog),
            MyItem("Мост", R.drawable.bridge)

        )

        val recyclerView = binding.recyclerView

        val adapter = ItemAdapter(data)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)


        val offsetDecoration = OffsetDecoration(start = 16, top = 16, end = 15, bottom = 16)
        recyclerView.addItemDecoration(offsetDecoration)

        return binding.root
    }


}