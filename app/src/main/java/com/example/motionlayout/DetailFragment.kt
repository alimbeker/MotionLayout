package com.example.motionlayout

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.motionlayout.databinding.FragmentDetailBinding
import java.util.concurrent.TimeUnit

class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private val imageId: Int by args.imageId
    private val title: String by args.title

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.image.setOnClickListener {
            binding.image.animate()
                .rotation(360f)
                .setDuration(500)
                .start()
        }
        binding.image = imageId
        binding.title.text = title

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)

    }




    }