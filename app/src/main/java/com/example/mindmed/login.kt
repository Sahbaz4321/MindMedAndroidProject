package com.example.mindmed

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.SignUpActivity
import com.shashank.sony.fancytoastlib.FancyToast

class login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn=findViewById<Button>(R.id.login_btn)
        val email=findViewById<EditText>(R.id.email_login)
        val password=findViewById<EditText>(R.id.password_login)
        val signUp=findViewById<TextView>(R.id.signUp)
        signUp.setOnClickListener {
            val intent=Intent(this, SignActivity::class.java)
            startActivity(intent)
        }


        btn.setOnClickListener{
            val email1=email.text.toString()
            val pass=password.text.toString()
            if(email1.equals("abc123@gmail.com")  && pass.equals("ab12")){
                FancyToast.makeText(this,"Successfully Login",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                val intent=Intent(this,HomeIcon::class.java)
                startActivity(intent)
            }
            else{
                FancyToast.makeText(this,"Credential Error",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();

            }

        }
    }
}