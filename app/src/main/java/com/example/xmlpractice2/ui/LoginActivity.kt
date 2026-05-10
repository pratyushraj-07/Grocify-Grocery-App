package com.example.xmlpractice2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlpractice2.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mobNumber = findViewById<TextInputEditText>(R.id.numberInput)
        val otpField = findViewById<TextInputEditText>(R.id.otp)
        val button = findViewById<Button>(R.id.verifyButton)


        button.setOnClickListener {

            val number = mobNumber.text.toString()
            val otp = otpField.text.toString()

            if(number.isEmpty() || otp.isEmpty()){
                Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show()
            }else if(otp == "1234"){

                Toast.makeText(this, "Login successfull", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Incorrect details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}