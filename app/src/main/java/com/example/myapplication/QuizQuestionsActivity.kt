package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myapplication.R.drawable.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*


class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener {

    private var mQuestionsList : ArrayList<Questions>? = null // object to get questions
    private var mCurrentPosition : Int = 1    // current question or current activity
    private var mSelectedOption : Int = 0     // option has the user selected
    private var mCorrectAnswer : Int = 0
    private var mUserName : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUserName  = intent.getStringExtra(Constants.USER_NAME)
        setContentView(R.layout.activity_quiz_questions)
        defaultOptionView()
         mQuestionsList = Constants.getQuestions()
        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

   private fun setQuestion()
    {
          val question = mQuestionsList!![mCurrentPosition - 1]
          defaultOptionView()
          if(mSelectedOption == mQuestionsList!!.size)
          {
              btn_submit.text = "FINISH"
          }else
          {
              btn_submit.text = "SUBMIT"
          }
          progressBar.progress = mCurrentPosition

          tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

          tv_question.text = question.question

          iv_image.setImageResource(question.image)

          tv_option_one.text = question.optionOne
          tv_option_two.text = question.optionTwo
          tv_option_three.text = question.optionThree
         tv_option_four.text = question.optionFour
    }

    private fun defaultOptionView()
    {
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background =  ContextCompat.getDrawable(this, default_option_border_bg)
        }

    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if((tv_option_one.background.constantState!!.equals(tv_option_two.background.constantState) &&
                    tv_option_one.background.constantState!!.equals(tv_option_three.background.constantState) &&
                    tv_option_one.background.constantState!!.equals(tv_option_four.background.constantState) &&
                    tv_option_two.background.constantState!!.equals(tv_option_three.background.constantState) &&
                    tv_option_three.background.constantState!!.equals(tv_option_four.background.constantState) &&
                    tv_option_two.background.constantState!!.equals(tv_option_four.background.constantState)))
                    Toast.makeText(this, "Please choose one", Toast.LENGTH_SHORT).show()

                else {

                    if (mSelectedOption <= 0) {
                        mCurrentPosition++


                        when {
                            mCurrentPosition <= mQuestionsList!!.size -> {
                                setQuestion()
                            }
                            else -> {

                              if(mCorrectAnswer >= (mQuestionsList!!.size)/2) {
                                  val intent = Intent(this, ResultActivity::class.java)
                                  intent.putExtra(Constants.USER_NAME, mUserName)
                                  intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                                  intent.putExtra(Constants.CORRECT_QUESTIONS, mCorrectAnswer)
                                  startActivity(intent)
                                  finish()
                              }else
                              {
                                  val intent = Intent(this, failure_activity::class.java)
                                  intent.putExtra(Constants.USER_NAME, mUserName)
                                  intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                                  intent.putExtra(Constants.CORRECT_QUESTIONS, mCorrectAnswer)
                                  startActivity(intent)
                                  finish()
                              }
                            }
                        }
                    } else {
                        val question = mQuestionsList?.get(mCurrentPosition - 1)
                        if (question!!.correctAnswer != mSelectedOption) {

                            answerView(mSelectedOption, wrong_option_border_bg)
                        } else {
                            mCorrectAnswer++
                        }
                        answerView(question.correctAnswer, correct_option_border_bg)

                        if (mSelectedOption == mQuestionsList!!.size) {
                            btn_submit.text = "FINISH"
                        } else {
                            btn_submit.text = "GO TO NEXT QUESTION"
                        }
                            mSelectedOption = 0

                    }
                }
                }
        }
    }

    private fun answerView(answer: Int,drawableView : Int)
    {
      when(answer)
      {
          1 ->{
              tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
          }
          2 ->{
              tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
          }
          3 ->{
              tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
          }
          4 ->{
              tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
          }
      }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNumber : Int)
    {
        defaultOptionView()
        mSelectedOption = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background =  ContextCompat.getDrawable(this, selected_option_border)
    }

}