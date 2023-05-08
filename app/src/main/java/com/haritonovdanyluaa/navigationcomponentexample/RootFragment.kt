package com.haritonovdanyluaa.navigationcomponentexample

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentMainBinding

class RootFragment : Fragment(R.layout.activity_main) {

    private var _binding : FragmentMainBinding? = null
    private val binding
        get() = _binding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding?.greenButton?.setOnClickListener {
            openBox(Color.YELLOW)
        }

        binding?.yellowButton?.setOnClickListener {
            openBox(Color.GREEN)
        }
    }

    private fun openBox(color: Int)
    {
        findNavController().navigate(R.id.action_rootFragment2_to_boxFragment, bundleOf(BoxFragment.COLOR to color))

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}