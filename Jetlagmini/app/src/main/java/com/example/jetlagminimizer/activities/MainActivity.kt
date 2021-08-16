package com.example.jetlagminimizer.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jetlagminimizer.R
import com.example.jetlagminimizer.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    //view binding
    private lateinit var binding: ActivityMainBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val navController = findNavController(R.id.main_fragment_container)

        bottomNavigationView.setupWithNavController(navController)

        //firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click, logout user
        /*binding.logoutBtn.setOnClickListener{
            firebaseAuth.signOut()
            checkUser()
        }*/

    }

    private fun checkUser() {
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser == null)
        {
            //user not logged in
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        else
        {
            //user logged in
            //get user info
            val email = firebaseUser.email
            //set email
//            findViewById<EditText>(R.id.uemail).text = email
        }
    }
}