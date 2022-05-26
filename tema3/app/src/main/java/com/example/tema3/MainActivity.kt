package com.example.tema3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.admin.AdminLogin
import com.example.tema3.angajat.AngajatLogin
import com.example.tema3.client.ClientLogin
import com.example.tema3.vanzator.VanzatorLogin

const val BASE_URL = "http://192.168.0.102:8080/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val admin = findViewById<Button>(R.id.admin)
        val client = findViewById<Button>(R.id.client)
        val vanzator = findViewById<Button>(R.id.vanzator)
        val angajat = findViewById<Button>(R.id.angajat)
        admin.setOnClickListener {
            val intent = Intent(applicationContext, AdminLogin::class.java)
            startActivity(intent)
        }
        client.setOnClickListener {
            val intent = Intent(applicationContext, ClientLogin::class.java)
            startActivity(intent)
        }
        vanzator.setOnClickListener {
            val intent = Intent(applicationContext, VanzatorLogin::class.java)
            startActivity(intent)
        }
        angajat.setOnClickListener {
            val intent = Intent(applicationContext, AngajatLogin::class.java)
            startActivity(intent)
        }
       // getFilms()
    }

    /*private fun getFilms() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(provideOkHttp())
            .build()
            .create(FilmInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<FilmItem>?> {
            override fun onResponse(
                call: Call<List<FilmItem>?>,
                response: Response<List<FilmItem>?>
            ) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()
                for(myData in responseBody){
                    //println(myData.id)
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
                    //break
                }

                val textView = findViewById<TextView>(R.id.textView16)
                textView.text = myStringBuilder
            }

            override fun onFailure(call: Call<List<FilmItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })

    }

    private fun provideOkHttp(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        httpBuilder.connectTimeout(30, TimeUnit.SECONDS)
        return httpBuilder.build()
    }*/

}