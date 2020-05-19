package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastNumeric: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun digitClick(view: View) {
        tvSolution.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View){
        tvSolution.text = ""
        lastNumeric = false
        lastDot = false
    }
    fun equalClick(view: View) {

    }

    fun onOperator(view: View){
        if(lastNumeric && !isOperatorAdded(tvSolution.text.toString())){
            tvSolution.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    private fun isOperatorAdded(value: String): Boolean{
        return if(value.startsWith("-")){false}else{
                    value.contains("/") ||
                    value.contains("+")||
                    value.contains("*")||
                    value.contains("-")}
    }

    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            tvSolution.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
}
