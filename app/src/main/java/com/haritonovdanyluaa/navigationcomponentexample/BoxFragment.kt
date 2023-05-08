package com.haritonovdanyluaa.navigationcomponentexample

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentBoxBinding
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentMainBinding
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {

    private var _binding : FragmentBoxBinding? = null
    private val binding
        get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBoxBinding.bind(view)
        val color = requireArguments().getInt(COLOR)
        binding?.root?.setBackgroundColor(color)

        binding?.goBackButton?.setOnClickListener {
            findNavController().popBackStack()
        }
        binding?.openSecretButton?.setOnClickListener {
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
        binding?.generateNumberButton?.setOnClickListener {
            val number = Random.nextInt(0, 1000)
            findNavController().previousBackStackEntry?.savedStateHandle?.set("random", number)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val COLOR = "color"
    }
}