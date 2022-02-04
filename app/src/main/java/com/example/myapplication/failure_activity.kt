package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.Constants.CORRECT_QUESTIONS
import com.example.myapplication.Constants.TOTAL_QUESTIONS
import com.example.myapplication.Constants.USER_NAME
import kotlinx.android.synthetic.main.activity_failure.*

class failure_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failure)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var username = intent.getStringExtra(USER_NAME)
        var totalQuestions = intent.getIntExtra(TOTAL_QUESTIONS,0)
        var correctAnswer = intent.getIntExtra(CORRECT_QUESTIONS,0)

        tv_name.text = username
        tv_score.text = "Your Score is $correctAnswer out of $totalQuestions"

        btn_tryAgain.setOnClickListener {

            startActivity(Intent(this,QuizQuestionsActivity::class.java))
             finish()
        }

        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}