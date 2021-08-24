package com.example.jetlagcure.databases

import java.util.*

data class Diary(
    val id: Int,
    val title: String,
    val content: String,
    val dateCreated: Date
)
