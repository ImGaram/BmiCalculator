package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //intent 로 전달받은 키와 몸무게
        val height = intent.getStringExtra("height")?.toInt()
        val weight = intent.getStringExtra("weight")?.toInt()

        //bmi 계산
        val bmi = weight?.div((Math.pow(height!!.div(100.0),2.0)))
//        val bmi1 = bmi?.let { Math.round(it) }
        bmi_text.text = bmi.toString()

        //결과 표시
        if (bmi != null) {
            when{
                bmi > 35 -> resultTextView.text = "고도 비만"
                bmi >= 35 -> resultTextView.text = "2단계 비만"
                bmi >= 30 -> resultTextView.text = "1단계 비만"
                bmi >= 25 -> resultTextView.text = "과체중"
                bmi >= 23 -> resultTextView.text = "정상"
                bmi < 18.5 -> resultTextView.text = "저체중"
            }
        }

        //이미지 표시
        if (bmi != null) {
            when{
                bmi >= 30 ->  // 비만
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
                bmi >= 25 ->  // 과체중
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
                bmi >= 23 ->  // 정상
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
                bmi < 18.5 ->  // 저체중
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
            }

            Toast.makeText(this, "$bmi", Toast.LENGTH_SHORT).show()
        }
    }
}