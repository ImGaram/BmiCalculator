package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultButton.setOnClickListener {
            val height = heightEditText.text.toString()
            val weight = weightEditText.text.toString()
            val intent = Intent(this,ResultActivity::class.java)
                .putExtra("height",height)
                .putExtra("weight",weight)
            startActivity(intent)
        }
    }
}