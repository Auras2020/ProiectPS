package com.example.tema3.client

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.MainActivity
import com.example.tema3.R

class ClientMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        val film = findViewById<Button>(R.id.film3)
        val spectacol = findViewById<Button>(R.id.spectacol1)
        val film1 = findViewById<Button>(R.id.film4)
        val spectacol1 = findViewById<Button>(R.id.spectacol3)
        val logout = findViewById<Button>(R.id.logout3)
        film.setOnClickListener {
            val intent = Intent(applicationContext, ClientFilm::class.java)
            startActivity(intent)
        }
        spectacol.setOnClickListener {
            val intent = Intent(applicationContext, ClientSpectacol::class.java)
            startActivity(intent)
        }
        film1.setOnClickListener {
            val intent = Intent(applicationContext, GetFilme1::class.java)
            startActivity(intent)
        }
        spectacol1.setOnClickListener {
            val intent = Intent(applicationContext, GetSpectacole1::class.java)
            startActivity(intent)
        }
        logout.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}