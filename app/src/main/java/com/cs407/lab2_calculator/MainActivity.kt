package com.cs407.lab2_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstNumber = findViewById<EditText>(R.id.myFirstNumber)
        val secondNumber = findViewById<EditText>(R.id.mySecondNumber)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        addButton.setOnClickListener {
            val num1 = firstNumber.text.toString().toInt()
            val num2 = secondNumber.text.toString().toInt()
            val intent = Intent(this, Result::class.java)
            val answer = (num1 + num2)
            intent.putExtra("finalResult", answer)
            startActivity(intent)
        }

        subtractButton.setOnClickListener {
            val num1 = firstNumber.text.toString().toInt()
            val num2 = secondNumber.text.toString().toInt()
            val intent = Intent(this, Result::class.java)
            val answer = (num1 - num2)
            intent.putExtra("finalResult", answer)
            startActivity(intent)
        }

        multiplyButton.setOnClickListener {
            val num1 = firstNumber.text.toString().toInt()
            val num2 = secondNumber.text.toString().toInt()
            val intent = Intent(this, Result::class.java)
            val answer = (num1 * num2)
            intent.putExtra("finalResult", answer)
            startActivity(intent)
        }

        divideButton.setOnClickListener {
            val num1 = firstNumber.text.toString().toInt()
            val num2 = secondNumber.text.toString().toInt()
            val errorMessage = "Divide by zero error"
            if (num2 == 0) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, Result::class.java)
                val answer = (num1 / num2)
                intent.putExtra("finalResult", answer)
                startActivity(intent)
            }
        }
    }
}