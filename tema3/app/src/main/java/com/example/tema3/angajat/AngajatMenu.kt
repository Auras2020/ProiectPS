package com.example.tema3.angajat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema3.MainActivity
import com.example.tema3.bilet.MyAdapter2
import com.example.tema3.R
import com.example.tema3.client.listBilete

class AngajatMenu : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter2
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angajat)
        val logout = findViewById<Button>(R.id.logout5)
        logout.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView4)

        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        getBilete()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getBilete() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView4)

        //val b1 = BiletItem(1, "a", "b")
        //val listBilete1 = mutableListOf(b1)

        //listBilete1.add(b1)

        myAdapter = MyAdapter2(baseContext, listBilete)
        myAdapter.notifyDataSetChanged()
        recyclerView.adapter = myAdapter

    }
}