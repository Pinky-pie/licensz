package com.example.jetlagcure.fragments.secondary.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jetlagcure.R
import com.example.jetlagcure.databinding.FragmentNewTripBinding

class NewTripFragment : Fragment() {
    private lateinit var binding: FragmentNewTripBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTripBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }
}