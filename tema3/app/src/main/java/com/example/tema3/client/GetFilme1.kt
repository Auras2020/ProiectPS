package com.example.tema3.client

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema3.BASE_URL
import com.example.tema3.R
import com.example.tema3.film.MyAdapter
import com.example.tema3.model.FilmInterface
import com.example.tema3.model.FilmItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetFilme1 : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getfilms1)
        val back = findViewById<Button>(R.id.back10)
        back.setOnClickListener {
            val intent = Intent(applicationContext, ClientMenu::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)

        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        getFilms()
    }

    private fun getFilms() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(FilmInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<FilmItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<FilmItem>?>,
                response: Response<List<FilmItem>?>
            ) {
                val responseBody = response.body()!!

                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<FilmItem>?>, t: Throwable) {
                Log.d("GetFilme1", "onFailure: " + t.message)
            }
        })

    }
}