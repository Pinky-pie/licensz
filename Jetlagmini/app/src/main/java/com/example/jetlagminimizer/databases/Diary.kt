package com.example.jetlagminimizer.databases

import java.util.*

data class Diary(
    val id: Int,
    val title: String,
    val content: String,
    val dateCreated: Date
)
