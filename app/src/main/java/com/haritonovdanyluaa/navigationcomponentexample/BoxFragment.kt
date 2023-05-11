package com.haritonovdanyluaa.navigationcomponentexample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentBoxBinding
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentMainBinding
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {

    private var _binding : FragmentBoxBinding? = null
    private val binding
        get() = _binding

    private val args : BoxFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBoxBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val color = args.color
        binding?.root?.setBackgroundColor(color)

        binding?.goBackButton?.setOnClickListener {
            findNavController().popBackStack()
        }
        binding?.openSecretButton?.setOnClickListener {
            findNavController().navigate(BoxFragmentDirections.actionBoxFragmentToSecretFragment())
        }
        binding?.generateNumberButton?.setOnClickListener {
            val number = Random.nextInt(0, 1000)
            //return result to previous fragment
            findNavController().previousBackStackEntry?.savedStateHandle?.set(REQUEST_CODE, number)

            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val REQUEST_CODE = "REQUEST_CODE"
    }
}