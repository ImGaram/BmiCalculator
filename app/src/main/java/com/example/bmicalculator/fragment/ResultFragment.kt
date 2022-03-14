package com.example.bmicalculator.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.bmicalculator.R
import com.example.bmicalculator.databinding.FragmentResultBinding
import kotlin.math.pow
import kotlin.math.roundToInt

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)

        //intent 로 전달받은 키와 몸무게
        val height = activity?.intent?.getStringExtra("height")?.toInt()
        val weight = activity?.intent?.getStringExtra("weight")?.toInt()
        Log.d("LOGD", "success: $height, $weight")

        //bmi 계산
        val bmi = weight?.div((height!!.div(100.0).pow(2.0)))
        val a = bmi?.roundToInt()

        setImage(bmi)
        resultBmi(a)

        return binding.root
    }

    private fun resultBmi(bmi: Int?) {
        val result = binding.resultTextView
        binding.bmiText.text = bmi.toString()

        //결과 표시
        if (bmi != null) {
            when{
                bmi > 35 -> result.text = "고도 비만"
                bmi >= 35 -> result.text = "2단계 비만"
                bmi >= 30 -> result.text = "1단계 비만"
                bmi >= 25 -> result.text = "과체중"
                bmi >= 23 -> result.text = "정상"
                bmi < 18.5 -> result.text = "저체중"
            }
        }
    }

    private fun setImage(bmi: Double?) {
        //이미지 표시
        val image = binding.imageView
        if (bmi != null) {
            when{
                bmi >= 30 ->  // 비만
                    image.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
                bmi >= 25 ->  // 과체중
                    image.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
                bmi >= 23 ->  // 정상
                    image.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
                bmi < 18.5 ->  // 저체중
                    image.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
            }
        }
    }
}