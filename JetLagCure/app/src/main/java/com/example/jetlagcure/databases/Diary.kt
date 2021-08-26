package com.example.jetlagcure.databases

import com.google.gson.annotations.SerializedName
import java.util.*

data class Diary(
//    @SerializedName("id")
    val id: Int,
    val title: String,
    val content: String,
    val dateCreated: Date
)
