package com.example.jetlagcure.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.jetlagcure.databases.Diary
import com.example.jetlagcure.R

class DiaryAdapter(private val diary_list: MutableList<Diary>, private val listener: OnItemClickListener): RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {
//class DiaryAdapter(private val diary_list: MutableList<Diary>): RecyclerView.Adapter<DiaryViewHolder>() {

    //    inner class DiaryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
    inner class DiaryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val title: TextView = itemView.findViewById(R.id.title)
        val contentOfDiary: TextView = itemView.findViewById(R.id.contentOfDiary)
        val createdDate: TextView = itemView.findViewById(R.id.dateCreated)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
            {
                listener.onItemClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.diary_note_item,
            parent, false
        )
        return DiaryViewHolder(itemView)
    }

    override fun getItemCount() = diary_list.size

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        val currentItem = diary_list[position]

        holder.title.text = currentItem.title
        holder.contentOfDiary.text = currentItem.content
        holder.createdDate.text = currentItem.dateCreated.toString()
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}

