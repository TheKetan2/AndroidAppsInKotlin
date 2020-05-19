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
        if(lastNumeric){
            var tvValue = tvSolution.text.toString()
            var prefix = ""

            try{
                if(tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if(tvValue.contains("-")){
                    val spiltValue = tvSolution.text.split("-")
                    var one = spiltValue[0]
                    var two = spiltValue[1]
                    if(!prefix.isEmpty()){
                        one = prefix+one
                    }
                    tvSolution.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                }else if(tvValue.contains("+")){
                    val spiltValue = tvSolution.text.split("+")
                    var one = spiltValue[0]
                    var two = spiltValue[1]
                    tvSolution.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                }else if(tvValue.contains("*")){
                    val spiltValue = tvSolution.text.split("*")
                    var one = spiltValue[0]
                    var two = spiltValue[1]
                    tvSolution.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                }else if(tvValue.contains("/")){
                    val spiltValue = tvSolution.text.split("/")
                    var one = spiltValue[0]
                    var two = spiltValue[1]
                    tvSolution.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                }
            }catch(e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String): String{
        var value = result
        if(result.contains(".0"))
            value = result.substring(0, result.length-2)
        return value
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
