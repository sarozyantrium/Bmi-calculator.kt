package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //This is for view binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this is also for binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        //inside this setcontent we have to write binding root
        setContentView(binding.root)

        binding.btnCalc.setOnClickListener {
            //Here we are calling the function calculateBMI

            calculateBMI()
        }
    }

    //Here we are creating function to calculate bmi ,later we will call this in button.
    private fun calculateBMI()
    {
        val weight=binding.edtWeight.text.toString().toFloatOrNull()
        val height=binding.edtHeight.text.toString().toFloatOrNull()

        if(weight !==null && height!==null)
        {
            val bmi=weight/(height/100).pow(2)
            val bmiresult= String.format("%.2f",bmi)

            val bmicategory=when
            {
                bmi <30 -> "UNDER WEIGHT"
                bmi<50 -> "NORMAL WEIGHT"
                bmi< 70-> "OVER WEIGHT"

                else -> "MOTA"
            }
            binding.resultText.text="BMI: $bmiresult\n Category: $bmicategory"

        }
        else{

            binding.resultText.text="INVALID INPUT"
        }

    }

}