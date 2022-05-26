package com.example.tema3.admin

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.MainActivity
import com.example.tema3.R

class AdminLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminlogin)
        val username = findViewById<EditText>(R.id.user)
        val password = findViewById<EditText>(R.id.pass)
        val login = findViewById<Button>(R.id.login)
        val back = findViewById<Button>(R.id.back)

        login.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()
            if(user.length < 3){
                Toast.makeText(this@AdminLogin, "Username is too short", Toast.LENGTH_SHORT).show()
            }
            else if(pass.length < 5){
                Toast.makeText(this@AdminLogin, "Password is too short", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@AdminLogin, "LogIn Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, AdminMenu::class.java)
                startActivity(intent)
            }
        }
        back.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}