package com.example.jetlagcure.fragments.secondary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jetlagcure.R
import com.example.jetlagcure.databases.Diary
import com.example.jetlagcure.databinding.FragmentDiaryNewBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class DiaryNewFragment : Fragment() {

    //for database
    private lateinit var database: DatabaseReference

    //for binding
    private lateinit var binding: FragmentDiaryNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryNewBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.saveDiary.setOnClickListener {
            val dTitle = binding.diaryNewTitle.text.toString()
            val dContent = binding.diaryNewContent.text.toString()
            val dCreatedDate = Calendar.getInstance().time

            if (dTitle.isEmpty() || dContent.isEmpty()) {
                Toast.makeText(context, "Can't save notes with empty fields!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener;
            }

            database = FirebaseDatabase.getInstance().getReference("Diaries")

            val Diary = Diary(1, dTitle, dContent, dCreatedDate)
            database.child(Diary.id.toString()).setValue(Diary).addOnSuccessListener {
                Toast.makeText(context, "Diary created", Toast.LENGTH_SHORT)
                    .show()
                findNavController().navigate(R.id.action_diaryNewFragment_to_diaryFragment)
            }.addOnFailureListener{
                Toast.makeText(context, "Diary can`t be created. Please try again!", Toast.LENGTH_SHORT)
                    .show()
            }

            binding.backToDiary.setOnClickListener{
                findNavController().navigate(R.id.action_diaryNewFragment_to_diaryFragment)
            }

        }

        return view
    }
}