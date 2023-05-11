package com.haritonovdanyluaa.navigationcomponentexample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentMainBinding
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentSecretBinding

class RootFragment : Fragment(R.layout.activity_main) {

    private var _binding : FragmentMainBinding? = null
    private val binding
        get() = _binding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.greenButton?.setOnClickListener {
            openBox(Color.GREEN, getString(R.string.green))
        }

        binding?.yellowButton?.setOnClickListener {
            openBox(Color.YELLOW, getString(R.string.yellow))
        }

        val liveData = findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Int>(BoxFragment.REQUEST_CODE)

        liveData?.observe(viewLifecycleOwner){
            if (it != null)
            {
                Toast.makeText(
                    requireContext(),
                    it.toString(),
                    Toast.LENGTH_LONG
                ).show()
                liveData.value = null
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun openBox(color: Int, colorName: String)
    {
        val direction = RootFragmentDirections.actionRootFragment2ToBoxFragment(color = color,colorName = colorName)
        findNavController().navigate(direction)
    }
}