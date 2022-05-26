package com.example.tema3.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.*

class AdminMenuExtins : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminmenu)
        val add = findViewById<Button>(R.id.add)
        val update = findViewById<Button>(R.id.update)
        val delete = findViewById<Button>(R.id.delete)
        val get = findViewById<Button>(R.id.get)
        val logout1 = findViewById<Button>(R.id.logout1)
        val back3 = findViewById<Button>(R.id.back3)
        add.setOnClickListener {
            val intent = Intent(applicationContext, AddFilm::class.java)
            startActivity(intent)
        }
        update.setOnClickListener {
            val intent = Intent(applicationContext, UpdateFilm::class.java)
            startActivity(intent)
        }
        delete.setOnClickListener {
            val intent = Intent(applicationContext, DeleteFilm::class.java)
            startActivity(intent)
        }
        get.setOnClickListener {
            val intent = Intent(applicationContext, GetFilme::class.java)
            startActivity(intent)
        }
        logout1.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        back3.setOnClickListener {
            val intent = Intent(applicationContext, AdminMenu::class.java)
            startActivity(intent)
        }
    }
}