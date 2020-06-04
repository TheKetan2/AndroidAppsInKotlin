package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.btn_roll)
        val countUpButton: Button = findViewById(R.id.btn_countUp)
        countUpButton.setOnClickListener{countUp()}
        rollButton.setOnClickListener{rollDice()}

    }

    private fun rollDice(){
        val resultText: TextView = findViewById(R.id.tvRollLabel)
        val randomInt = (0..6).random()
        resultText.text = randomInt.toString()
        Toast.makeText(
            this,
            "button clicked",
            Toast.LENGTH_SHORT).show()
    }

    private fun countUp(){
        val resultText: TextView = findViewById(R.id.tvRollLabel)
        val countUpInt = resultText.text.toString().toInt() +1
        resultText.text = countUpInt.toString()
    }
    

}
