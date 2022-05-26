package com.example.tema3.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.*

class AdminMenuExtins1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminmenu1)
        val add = findViewById<Button>(R.id.add1)
        val update = findViewById<Button>(R.id.update1)
        val delete = findViewById<Button>(R.id.delete1)
        val get = findViewById<Button>(R.id.get1)
        val logout1 = findViewById<Button>(R.id.logout2)
        val back3 = findViewById<Button>(R.id.back4)
        add.setOnClickListener {
            val intent = Intent(applicationContext, AddSpectacol::class.java)
            startActivity(intent)
        }
        update.setOnClickListener {
            val intent = Intent(applicationContext, UpdateSpectacol::class.java)
            startActivity(intent)
        }
        delete.setOnClickListener {
            val intent = Intent(applicationContext, DeleteSpectacol::class.java)
            startActivity(intent)
        }
        get.setOnClickListener {
            val intent = Intent(applicationContext, GetSpectacole::class.java)
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