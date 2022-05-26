package com.example.tema3.client

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.BASE_URL
import com.example.tema3.R
import com.example.tema3.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientfilm)
        val buy = findViewById<Button>(R.id.buy)
        val back = findViewById<Button>(R.id.back6)
        buy.setOnClickListener {
            cumparareBilet()
        }
        back.setOnClickListener {
            val intent = Intent(applicationContext, ClientMenu::class.java)
            startActivity(intent)
        }
    }

    private fun cumparareBilet() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(FilmInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        val nume = findViewById<EditText>(R.id.nume1)

        retrofitData.enqueue(object : Callback<List<FilmItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<FilmItem>?>,
                response: Response<List<FilmItem>?>
            ) {
                val responseBody = response.body()!!

                var id1 = 0
                var find = 0
                var n = ""

                for(myData in responseBody){
                    if(myData.nume.equals(nume.text.toString())){
                        n = myData.nume
                        id1 = myData.id
                        s1 += myData.pret
                        s = s1 + s2
                        find = 1
                        break
                    }
                }

                if(find == 1){

                    nrBil++

                    val retrofitBuilder1 = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()
                        .create(BiletInterface::class.java)

                    val retrofitData1 = retrofitBuilder1.insertBiletFilm(clientId.toLong(), id1.toLong())

                    retrofitData1.enqueue(object : Callback<BiletItem?> {
                        @SuppressLint("NotifyDataSetChanged")
                        override fun onResponse(
                            call: Call<BiletItem?>,
                            response: Response<BiletItem?>
                        ) {
                            nume.setText("")
                            Toast.makeText(this@ClientFilm, "Film reserved", Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(call: Call<BiletItem?>, t: Throwable) {
                            Toast.makeText(this@ClientFilm, "Film reserved", Toast.LENGTH_SHORT).show()
                            Log.d("ClientFilm", "onFailure: " + t.message)
                        }
                    })

                    val bItem = BiletItem(nrBil, numClient, n)
                    listBilete.add(bItem)

                    val intent = Intent(applicationContext, ClientMenu::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@ClientFilm, "Film with name " + nume.text.toString() + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<FilmItem>?>, t: Throwable) {
                Log.d("ClientFilm", "onFailure: " + t.message)
            }
        })

    }
}