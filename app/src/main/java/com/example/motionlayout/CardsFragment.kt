package com.example.motionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionlayout.databinding.FragmentCardsBinding
import com.example.motionlayout.databinding.FragmentStartBinding

class CardsFragment : Fragment() {
    private lateinit var binding : FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }


}