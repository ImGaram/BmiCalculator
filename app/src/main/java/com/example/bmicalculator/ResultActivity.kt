package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.bmicalculator.databinding.ActivityResultBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    lateinit var nav: BottomNavigationView
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        nav = binding.bottomNavigationView
        setBottomNav(navHostFragment)
    }

    private fun setBottomNav(navHost: NavHostFragment) {
        val navController = navHost.navController
        nav.setupWithNavController(navController)
    }
}