package com.example.numberfactsapp

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set policy for thread
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        //listener for button
        nextBtn.setOnClickListener {
            newFact()
        }
    }

    private fun newFact() {
        //set up text view to show the results
        val mainText: TextView = findViewById(R.id.mainText)
        //set up the edit text
        val editTextCat: EditText = findViewById(R.id.editTextCat)
        //set up the edit text
        val editTextNumber: EditText = findViewById(R.id.editTextNum)
        //set the text in the edit text to num
        val num: Editable? = editTextNumber.text
        //set the text in the edit text to cat
        var cat = editTextCat.text.toString().toLowerCase()

        //check for a valid input
        if(num.toString().toIntOrNull() != null && cat == "math" || cat == "trivia" || cat == "year"){
            val result = URL("http://numbersapi.com/$num/$cat").readText()
            mainText.text = result
        } else {
            Toast.makeText(applicationContext,"Invalid Input",Toast.LENGTH_SHORT).show()
        }

    }


}