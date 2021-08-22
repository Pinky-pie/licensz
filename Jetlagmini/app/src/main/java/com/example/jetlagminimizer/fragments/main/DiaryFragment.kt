package com.example.jetlagminimizer.fragments.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetlagminimizer.R
import com.example.jetlagminimizer.activities.LoginActivity
import com.example.jetlagminimizer.databases.Diary
import com.example.jetlagminimizer.databinding.FragmentDiaryBinding
import com.example.jetlagminimizer.model.Communicator
import com.example.jetlagminimizer.model.DiaryAdapter
import com.google.type.DateTime
import java.time.LocalDate
import java.time.LocalDate.now
import java.time.LocalDateTime.now
import java.util.*

class DiaryFragment : Fragment(), DiaryAdapter.OnItemClickListener {
//class DiaryFragment : Fragment() {

    //for recyclerView
    private lateinit var diary_list: RecyclerView

    //for binding
    private lateinit var binding: FragmentDiaryBinding

    //for adapter to show the list data
    private lateinit var adapter: DiaryAdapter

    private lateinit var list: MutableList<Diary>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryBinding.inflate(inflater, container, false)
        val view = binding.root

        list = mutableListOf()
        list.add(Diary(0, "First", "first", Calendar.getInstance().time))
        list.add(Diary(0, "Second", "second", Calendar.getInstance().time))
        list.add(Diary(0, "Third", "third", Calendar.getInstance().time))

        diary_list = binding.recDiaryList

        diary_list.layoutManager = LinearLayoutManager(this.context)
        diary_list.adapter = DiaryAdapter(list, this)

        return view
    }

    override fun onItemClick(position: Int) {
        val bundle = bundleOf(
            "diaryTitle" to list[position].title,
            "diaryContent" to list[position].content,
            "createdDate" to list[position].dateCreated.toString(),
        )
        findNavController().navigate(R.id.action_diaryFragment_to_diaryDetailFragment, bundle)
    }
}