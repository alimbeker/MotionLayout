package com.example.motionlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.motionlayout.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private lateinit var binding : FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            navigate()
        }
        return binding.root
    }

    private fun navigate() {
        findNavController().navigate(
            R.id.action_startFragment_to_cardsFragment
        )
    }


}