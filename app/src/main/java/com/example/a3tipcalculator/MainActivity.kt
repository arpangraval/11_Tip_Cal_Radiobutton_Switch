package com.example.a3tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.a3tipcalculator.R.string.tip_amount
import com.example.a3tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class   MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    binding.calculateButton.setOnClickListener { calulatetip() }
    }
    private fun calulatetip() {
        val cost = binding.costOfService.text.toString()
        val costOfService = cost.toDouble()
        val selOption = binding.tipOptions.checkedRadioButtonId

        val per = when (selOption) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = costOfService * per
        if(binding.roundUpSwitch.isChecked)
        {
            tip = kotlin.math.ceil(tip)
    }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(tip_amount, formattedTip)
    }
}