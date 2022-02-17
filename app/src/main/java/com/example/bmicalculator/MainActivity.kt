package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultButton.setOnClickListener {
            val height = binding.heightEditText.text.toString()
            val weight = binding.weightEditText.text.toString()
            val intent = Intent(this,ResultActivity::class.java)
                .putExtra("height",height)
                .putExtra("weight",weight)
            startActivity(intent)
        }
    }
}