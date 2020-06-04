package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.btn_roll)


        diceImage1 = findViewById(R.id.image_dice1)
        diceImage2 = findViewById(R.id.image_dice2)

        rollButton.setOnClickListener{rollDice()}

    }

    private fun randomImage(): Int{
        val randomInt = (0..6).random()
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        return drawableResource
    }


    private fun rollDice(){


        diceImage1.setImageResource(randomImage())
        diceImage2.setImageResource(randomImage())
        Toast.makeText(
            this,
            "button clicked",
            Toast.LENGTH_SHORT).show()
    }


    

}
