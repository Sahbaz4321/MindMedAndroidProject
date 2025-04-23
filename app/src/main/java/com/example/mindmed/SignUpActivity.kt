package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mindmed.HomeIcon
import com.example.mindmed.R

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nameEditText = findViewById<EditText>(R.id.name_text)
        val emailEditText = findViewById<EditText>(R.id.email_text)
        val passwordEditText = findViewById<EditText>(R.id.password_text)
        val confirmPasswordEditText = findViewById<EditText>(R.id.password_confirm_text)

        val signUp_btn=findViewById<Button>(R.id.signup_btn)
        signUp_btn.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            if (name.equals("Sahbaz") && email.equals("abc@gmail.com") && password.equals(
                    "abcd"
                ) && confirmPassword.equals("abcd")
            ) {


                val intent = Intent(this, HomeIcon::class.java)
                startActivity(intent)
            }
            else{

                Toast.makeText(this,"Please Enter correct details ", Toast.LENGTH_LONG).show()
            }
        }
    }
}