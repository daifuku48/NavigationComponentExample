package com.haritonovdanyluaa.navigationcomponentexample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
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

        parentFragmentManager.setFragmentResultListener(BoxFragment.REQUEST_CODE, viewLifecycleOwner) { _, data ->
            val number = data.getInt(BoxFragment.EXTRA_REQUEST_CODE)
            Toast.makeText(requireContext(),number.toString(), Toast.LENGTH_LONG).show()
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
        findNavController().navigate(R.id.action_rootFragment2_to_boxFragment, bundleOf(BoxFragment.COLOR_ARG to color, BoxFragment.COLOR_NAME to colorName))
    }
}