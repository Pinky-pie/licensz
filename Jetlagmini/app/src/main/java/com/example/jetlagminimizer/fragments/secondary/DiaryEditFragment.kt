package com.example.jetlagminimizer.fragments.secondary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jetlagminimizer.R
import com.example.jetlagminimizer.databinding.FragmentDiaryDetailBinding
import com.example.jetlagminimizer.databinding.FragmentDiaryEditBinding

class DiaryEditFragment : Fragment() {

    private lateinit var binding: FragmentDiaryEditBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryEditBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.backToDiaryDetail.setOnClickListener{
            findNavController().navigate(R.id.action_diaryEditFragment_to_diaryDetailFragment)
        }

        return view
    }

}