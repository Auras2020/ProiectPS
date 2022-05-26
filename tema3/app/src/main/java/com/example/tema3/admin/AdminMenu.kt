package com.example.tema3.admin

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.MainActivity
import com.example.tema3.R

class AdminMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        val film = findViewById<Button>(R.id.film)
        val spectacol = findViewById<Button>(R.id.spectacol)
        val logout = findViewById<Button>(R.id.logout)
        film.setOnClickListener {
            val intent = Intent(applicationContext, AdminMenuExtins::class.java)
            startActivity(intent)
        }
        spectacol.setOnClickListener {
            val intent = Intent(applicationContext, AdminMenuExtins1::class.java)
            startActivity(intent)
        }
        logout.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}