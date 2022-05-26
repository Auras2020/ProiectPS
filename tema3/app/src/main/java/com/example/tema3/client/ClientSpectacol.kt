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

class ClientSpectacol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientspectacol)
        val buy = findViewById<Button>(R.id.buy1)
        val back = findViewById<Button>(R.id.back7)
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
            .create(SpectacolInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        val nume = findViewById<EditText>(R.id.nume2)

        retrofitData.enqueue(object : Callback<List<SpectacolItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<SpectacolItem>?>,
                response: Response<List<SpectacolItem>?>
            ) {
                val responseBody = response.body()!!

                var id1 = 0
                var find = 0
                var n = ""

                for(myData in responseBody){
                    if(myData.nume.equals(nume.text.toString())){
                        n = myData.nume
                        s2 += myData.pret
                        s = s1 + s2
                        id1 = myData.id
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

                    val retrofitData1 = retrofitBuilder1.insertBiletSpectacol(clientId.toLong(), id1.toLong())

                    retrofitData1.enqueue(object : Callback<SpectacolItem?> {
                        @SuppressLint("NotifyDataSetChanged")
                        override fun onResponse(
                            call: Call<SpectacolItem?>,
                            response: Response<SpectacolItem?>
                        ) {
                            nume.setText("")
                            Toast.makeText(this@ClientSpectacol, "Spectacol reserved", Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(call: Call<SpectacolItem?>, t: Throwable) {
                            Toast.makeText(this@ClientSpectacol, "Spectacol reserved", Toast.LENGTH_SHORT).show()
                            Log.d("ClientSpectacol", "onFailure: " + t.message)
                        }
                    })

                    val bItem = BiletItem(nrBil, numClient, n)
                    listBilete.add(bItem)

                    val intent = Intent(applicationContext, ClientMenu::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@ClientSpectacol, "Spectacol with name " + nume.text.toString() + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<SpectacolItem>?>, t: Throwable) {
                Log.d("ClientSpectacol", "onFailure: " + t.message)
            }
        })

    }
}