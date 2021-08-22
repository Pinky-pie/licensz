package com.example.jetlagminimizer.fragments.main

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jetlagminimizer.R
import com.example.jetlagminimizer.activities.LoginActivity
import com.example.jetlagminimizer.databinding.FragmentProfileBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        //initialize firebase
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtn.setOnClickListener{
            firebaseAuth.signOut()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            checkUser()
        }
        return view
    }

    private fun checkUser() {
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser == null)
        {
            //user not logged in
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            //finish()
        }
        else
        {
            //user logged in
            //get user info
            binding.googleEmail.text = firebaseUser.email
            Picasso.get().load(firebaseUser.photoUrl).resize(500,500).into(binding.googleAvatar)
            binding.googleName.text = firebaseUser.displayName
        }
    }

}