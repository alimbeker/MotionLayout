package com.example.motionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.GridLayoutManager
import com.example.motionlayout.databinding.FragmentCardsBinding
import com.example.motionlayout.databinding.ItemDesignBinding

class CardsFragment : Fragment() {
    private lateinit var binding : FragmentCardsBinding
    private lateinit var itemBinding : ItemDesignBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        itemBinding = ItemDesignBinding.inflate(inflater,container, false)

        val data = listOf(
            MyItem("Улица", R.drawable.street),
            MyItem("Реклама", R.drawable.time_square),
            MyItem("Статуя Свободы", R.drawable.liberty_state1),
            MyItem("Статуя Свободы", R.drawable.liberty_state2),
            MyItem("Песик", R.drawable.dog),
            MyItem("Мост", R.drawable.bridge)

        )

        val recyclerView = binding.recyclerView

        adapter = ItemAdapter(data)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)


        val offsetDecoration = OffsetDecoration(start = 16, top = 16, end = 15, bottom = 16)
        recyclerView.addItemDecoration(offsetDecoration)




        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.itemClick = { it1, it2 ->


                findNavController().navigate(
                    CardsFragmentDirections.actionCardsFragmentToDetailFragment(it1.imageResId,it1.text),
                    it2
                )

        }

    }


}