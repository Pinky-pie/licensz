package com.example.jetlagminimizer.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetlagminimizer.R

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setupActionBarWithNavController(findNavController(R.id.fragment_container))
        supportActionBar?.hide()
    }
}