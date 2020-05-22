package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_quenstion.*


class QuizQuenstionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_quenstion)

        val questionList = Constants.getQuestion()

        val currentPosition = 1
        val question: Question? = questionList[currentPosition-1]
        progressbar.progress = currentPosition
        tv_progress.text = "$currentPosition"+"/"+progressbar.max
        tv_questionId.text = question!!.question
        ivFlag.setImageResource(question.image)

        tv_option_one.setText(question.optionOne)
        tv_option_two.setText(question.optionTwo)
        tv_option_three.setText(question.optionThree)
        tv_option_four.setText(question.optionFour)
    }
}
