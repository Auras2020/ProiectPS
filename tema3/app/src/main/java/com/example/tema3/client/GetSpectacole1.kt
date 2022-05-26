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
import com.example.tema3.model.SpectacolInterface
import com.example.tema3.model.SpectacolItem
import com.example.tema3.spectacol.MyAdapter1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetSpectacole1 : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter1
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getspectacole1)
        val back = findViewById<Button>(R.id.back11)
        back.setOnClickListener {
            val intent = Intent(applicationContext, ClientMenu::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)

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

                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)

                myAdapter = MyAdapter1(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<SpectacolItem>?>, t: Throwable) {
                Log.d("GetSpectacole1", "onFailure: " + t.message)
            }
        })

    }
}