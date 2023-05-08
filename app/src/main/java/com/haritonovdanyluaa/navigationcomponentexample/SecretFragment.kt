package com.haritonovdanyluaa.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.haritonovdanyluaa.navigationcomponentexample.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {
    private var _binding : FragmentSecretBinding? = null
    private val binding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecretBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.closeSecretButton?.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment2, false)
        }
        binding?.closeWholeBoxButton?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}