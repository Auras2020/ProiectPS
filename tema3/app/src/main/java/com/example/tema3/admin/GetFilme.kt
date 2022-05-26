package com.example.tema3.admin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema3.BASE_URL
import com.example.tema3.film.MyAdapter
import com.example.tema3.R
import com.example.tema3.model.FilmInterface
import com.example.tema3.model.FilmItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetFilme : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getfilms)
        val back = findViewById<Button>(R.id.back8)
        back.setOnClickListener {
            val intent = Intent(applicationContext, AdminMenuExtins::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

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

                /*val myStringBuilder = StringBuilder()
                for(myData in responseBody){
                    myStringBuilder.append("id: ")
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("nume: ")
                    myStringBuilder.append(myData.nume)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("gen: ")
                    myStringBuilder.append(myData.gen)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("varsta: ")
                    myStringBuilder.append(myData.varsta)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("tip: ")
                    myStringBuilder.append(myData.tip)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("data: ")
                    myStringBuilder.append(myData.data)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("capacitate: ")
                    myStringBuilder.append(myData.capacitate)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("pret: ")
                    myStringBuilder.append(myData.pret)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("regizor: ")
                    myStringBuilder.append(myData.regizor)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("actori: ")
                    myStringBuilder.append(myData.actori)
                    myStringBuilder.append("\n")
                    myStringBuilder.append("\n")
                }

                val listView = findViewById<ListView>(R.id.listView)
                listView.deferNotifyDataSetChanged()*/

                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<FilmItem>?>, t: Throwable) {
                d("GetFilme", "onFailure: " + t.message)
            }
        })

    }
}

