package com.example.tema3.admin

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
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddSpectacol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addspectacol)
        val add = findViewById<Button>(R.id.addspectacol)
        val back = findViewById<Button>(R.id.back5)
        add.setOnClickListener {
            process()
        }
        back.setOnClickListener {
            val intent = Intent(applicationContext, AdminMenuExtins1::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    private fun process() {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
            .create(SpectacolInterface::class.java)

        val nume = findViewById<EditText>(R.id.nume3)
        val tip_muzica = findViewById<EditText>(R.id.tip_muzica)
        val data = findViewById<EditText>(R.id.data1)
        val pret = findViewById<EditText>(R.id.locatie)
        val artisti = findViewById<EditText>(R.id.artisti)
        val int_orar = findViewById<EditText>(R.id.int_orar)

        var flag = 0
        if(tip_muzica.text.toString().equals("")){
            flag = 1
            tip_muzica.setText("tip muzica must have a value")
        }
        if(data.text.toString().equals("")){
            flag = 1
            data.setText("data must have a value")
        }

        var p = 0

        try {
            p = (pret.text.toString()).toInt()
        } catch (exception: NumberFormatException) {
            pret.setTextColor(R.color.red)
            pret.setText("pret must be a number")
        }

        if(nume.text.toString().equals("")){
            flag = 1
            nume.setText("nume must have a value")
        }
        if(artisti.text.toString().equals("")){
            flag = 1
            artisti.setText("artisti must have a value")
        }
        if(int_orar.text.toString().equals("")){
            flag = 1
            int_orar.setText("interval orar must have a value")
        }

        val retrofitData: Call<SpectacolItem>

        if (flag == 1 || p == 0){
            Toast.makeText(this@AddSpectacol, "Could not add spectacol", Toast.LENGTH_SHORT).show()
            //val intent = Intent(applicationContext, AddFilm::class.java)
            //startActivity(intent)
        }
        else {
            val spectacol1 = SpectacolItem(artisti.text.toString(), data.text.toString(), 0,
                int_orar.text.toString(), p, nume.text.toString(),
                tip_muzica.text.toString())

            retrofitData = retrofitBuilder.insertData(spectacol1)

            retrofitData.enqueue(object : Callback<SpectacolItem?> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<SpectacolItem?>,
                    response: Response<SpectacolItem?>
                ) {

                    nume.setText("")
                    tip_muzica.setText("")
                    pret.setText("")
                    artisti.setText("")
                    data.setText("")
                    int_orar.setText("")

                    Toast.makeText(this@AddSpectacol, "Spectacol has been added", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<SpectacolItem?>, t: Throwable) {
                    Toast.makeText(this@AddSpectacol, "Spectacol has been added", Toast.LENGTH_SHORT).show()
                    Log.d("AddSpectacol", "onFailure: " + t.message)
                }
            })

            val intent = Intent(applicationContext, AdminMenu::class.java)
            startActivity(intent)
        }

    }
}