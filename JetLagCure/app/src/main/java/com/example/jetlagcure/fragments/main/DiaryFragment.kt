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
import androidx.recyclerview.widget.RecyclerView
import com.example.jetlagcure.R
import com.example.jetlagcure.databases.Diary
import com.example.jetlagcure.databinding.FragmentDiaryBinding
import com.example.jetlagcure.model.DiaryAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray


class DiaryFragment : Fragment(), DiaryAdapter.OnItemClickListener {
    //for database
    private lateinit var database: DatabaseReference

    var diariesFromFirebase: MutableLiveData<MutableList<Diary>> = MutableLiveData()

    //for recyclerView
    private lateinit var diary_list: RecyclerView

    //for binding
    private lateinit var binding: FragmentDiaryBinding

    //for adapter to show the list data
    private lateinit var adapter: DiaryAdapter

    //to load the diaries
    private lateinit var fStore: FirebaseFirestore

    private lateinit var list: MutableList<Diary>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryBinding.inflate(inflater, container, false)
        val view = binding.root

        /*list = mutableListOf()
        list.add(Diary(0, "First", "first", Calendar.getInstance().time))
        list.add(Diary(0, "Second", "second", Calendar.getInstance().time))
        list.add(Diary(0, "Third", "third", Calendar.getInstance().time))

        diary_list = binding.recDiaryList

        diary_list.layoutManager = LinearLayoutManager(this.context)
        diary_list.adapter = DiaryAdapter(list, this)
        */
        getAllDiariesFromFirebase()

        binding.addNewDiary.setOnClickListener{
            findNavController().navigate(R.id.action_diaryFragment_to_diaryNewFragment)
        }

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

    fun getAllDiariesFromFirebase() {
        database = FirebaseDatabase.getInstance().getReference("Diaries")
        database.get().addOnSuccessListener {
//                Log.d("diary", "content: $it")
//                        Toast.makeText(context, "" +
//                        "diary ${it.value}", Toast.LENGTH_SHORT).show()
//            val jsonArray = JSONArray(it)

                binding.fos.text = it.child(Diary().id.toString()).toString()
        }
    }
}