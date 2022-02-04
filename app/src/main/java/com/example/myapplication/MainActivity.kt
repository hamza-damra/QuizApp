package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
       val editText = findViewById<EditText>(R.id.editText)
               val button_start = findViewById<Button>(R.id.btn_start)
        button_start.setOnClickListener {

            if(editText.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please enter your name !",Toast.LENGTH_SHORT).show()
            }else
            {
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,editText.text.toString())
                startActivity(intent)
                finish()
            }

        }


    }
}