package com.haritonovdanyluaa.navigationcomponentexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {
    private var _binding : FragmentSecretBinding? = null
    private val binding
        get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecretBinding.bind(view)
        binding?.closeSecretButton?.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment2, false)
        }
        binding?.closeWholeBoxButton?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}