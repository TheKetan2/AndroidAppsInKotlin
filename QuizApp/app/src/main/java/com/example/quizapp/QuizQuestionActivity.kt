package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_quenstion.*


class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question> ?=null
    private var mSelectedOption: Int =0

    private  var mCorrectAnswers: Int = 0

    private var mUserName: String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_quenstion)
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestion()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

    }

    private fun setQuestion(){

//        mCurrentPosition = 1
        val question= mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition"+"/"+ progressBar.max
        tv_questionId.text = question!!.question
        ivFlag.setImageResource(question.image)

        tv_option_one.setText(question.optionOne)
        tv_option_two.setText(question.optionTwo)
        tv_option_three.setText(question.optionThree)
        tv_option_four.setText(question.optionFour)
        btn_submit.setOnClickListener(this)
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_backgroung)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three,  3)

            }
            R.id.tv_option_four ->{
                selectedOptionView(tv_option_four,  4)
            }
            R.id.btn_submit ->{
                if(mSelectedOption == 0){
                    mCurrentPosition++

                    when{mCurrentPosition <= mQuestionsList!!.size ->{
                        setQuestion()
                    }else ->{
                        Toast.makeText(
                            this,
                            "You have successfully completed the Quiz",
                            Toast.LENGTH_LONG).show()
                        val intent = Intent(
                            this,
                            Result::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_backgroung)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_backgroung)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOption = 0
                }

            }
        }

    }

    private fun answerView(answer: Int, dravableView: Int){
        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this,dravableView)
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(this,dravableView)
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(this,dravableView)
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(this,dravableView)
            }
        }
    }

    private  fun selectedOptionView(tv: TextView, selectedOptionNum: Int ){
        defaultOptionsView()
        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
    }
}
