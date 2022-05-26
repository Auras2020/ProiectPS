package com.example.tema3.admin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema3.BASE_URL
import com.example.tema3.spectacol.MyAdapter1
import com.example.tema3.R
import com.example.tema3.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetSpectacole : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter1
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getspectacole)
        val back = findViewById<Button>(R.id.back9)
        back.setOnClickListener {
            val intent = Intent(applicationContext, AdminMenuExtins1::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)

        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        getSpectacole()
    }

    private fun getSpectacole() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(SpectacolInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<SpectacolItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<SpectacolItem>?>,
                response: Response<List<SpectacolItem>?>
            ) {
                val responseBody = response.body()!!

                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)

                myAdapter = MyAdapter1(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<SpectacolItem>?>, t: Throwable) {
                Log.d("GetSpectacole", "onFailure: " + t.message)
            }
        })

    }
}