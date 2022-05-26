package com.example.tema3.vanzator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.*
import com.example.tema3.client.s
import com.example.tema3.client.s1
import com.example.tema3.client.s2

class VanzatorMenu : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vanzator)
        val logout = findViewById<Button>(R.id.logout4)

        val sum1 = findViewById<TextView>(R.id.textView10)
        val sum2 = findViewById<TextView>(R.id.textView11)
        val sum = findViewById<TextView>(R.id.textView12)

        sum1.setText("Filme: " + s1 +  " lei")
        sum2.setText("Spectacole: " + s2 +  " lei")
        sum.setText("Total: " + s +  " lei")

        logout.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}