package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val userName = intent.getStringExtra(Constants.USER_NAME)
        val totalQue = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tv_username.text = userName
        tv_score.text = "Your score is ${correctAns} out of ${totalQue}"

        btn_finish.setOnClickListener {
            startActivity(Intent(
                this, MainActivity::class.java
                 )
            )
            finish()
        }

    }
}
