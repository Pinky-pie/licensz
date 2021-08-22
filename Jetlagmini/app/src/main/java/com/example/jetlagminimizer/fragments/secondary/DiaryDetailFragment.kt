package com.example.jetlagminimizer.fragments.secondary

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.jetlagminimizer.R
import com.example.jetlagminimizer.databinding.FragmentDiaryDetailBinding

class DiaryDetailFragment : Fragment() {

    //for binding
    private lateinit var binding: FragmentDiaryDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.backToDiary.setOnClickListener{
            findNavController().navigate(R.id.action_diaryDetailFragment_to_diaryFragment)
        }

        val diaryContent = binding.diaryDetailContent
        val diaryTitle = binding.diaryTitle
        val diaryCreatedDate = binding.diaryDetailCreatedDate

        diaryContent.movementMethod = ScrollingMovementMethod()

        diaryTitle.text = arguments?.getString("diaryTitle")
        diaryContent.text = arguments?.getString("diaryContent")
        diaryCreatedDate.text = arguments?.getString("createdDate")

        binding.editDiary.setOnClickListener{
            val bundle = bundleOf(
                "diaryTitle" to diaryTitle.text,
                "diaryContent" to diaryContent.text,
                "createdDate" to diaryCreatedDate.text,
            )
            findNavController().navigate(R.id.action_diaryDetailFragment_to_diaryEditFragment, bundle)
        }

        return view
    }
}