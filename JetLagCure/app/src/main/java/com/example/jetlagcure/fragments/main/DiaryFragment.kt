package com.example.jetlagcure.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetlagcure.R
import com.example.jetlagcure.databases.Diary
import com.example.jetlagcure.databinding.FragmentDiaryBinding
import com.example.jetlagcure.model.DiaryAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import org.json.JSONArray
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class DiaryFragment : Fragment(), DiaryAdapter.OnItemClickListener {
    //for database
    private lateinit var database: DatabaseReference

    var diariesFromFirebase: MutableLiveData<MutableList<Diary>> = MutableLiveData()

    //for binding
    private lateinit var binding: FragmentDiaryBinding

    //for adapter to show the list data
    private lateinit var adapter: DiaryAdapter

    private lateinit var fStore: FirebaseFirestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryBinding.inflate(inflater, container, false)
        val view = binding.root
        val recView = binding.recDiaryList


        val list :MutableList<Diary> = mutableListOf()
        list.add(Diary(0, "First", "first", Calendar.getInstance().time))
        list.add(Diary(0, "Second", "second", Calendar.getInstance().time))
        list.add(Diary(0, "Third", "third", Calendar.getInstance().time))


        recView.layoutManager = LinearLayoutManager(this.context)
        recView.adapter = DiaryAdapter(list, this)

        //              IMPLEMENTALNI A DIARY-S MESET LOKALIS ADATBAZISSAL


//        diariesFromFirebase.observe(viewLifecycleOwner, {
//            recView.layoutManager = LinearLayoutManager(this.context)
//            recView.adapter = DiaryAdapter(it, this)
//            recView.setHasFixedSize(true)
//        })

        binding.addNewDiary.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_diaryNewFragment)
        }

        return view
    }

    override fun onItemClick(position: Int) {
        //ATKULDENI AZ ID-T A MEGNYOMOTT DIARY-ROL A LOKALIS ADATBAZISBOL
        findNavController().navigate(R.id.action_diaryFragment_to_diaryDetailFragment)
    }
}