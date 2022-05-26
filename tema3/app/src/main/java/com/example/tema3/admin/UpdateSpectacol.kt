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

class UpdateSpectacol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatespectacol)
        val update = findViewById<Button>(R.id.updatespectacol)
        val back = findViewById<Button>(R.id.back5)
        update.setOnClickListener {
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

        val id = findViewById<EditText>(R.id.id3)
        val nume = findViewById<EditText>(R.id.nume)
        val tip_muzica = findViewById<EditText>(R.id.tip_muzica)
        val data = findViewById<EditText>(R.id.data1)
        val pret = findViewById<EditText>(R.id.locatie)
        val artisti = findViewById<EditText>(R.id.artisti)
        val int_orar = findViewById<EditText>(R.id.int_orar)

        var flag = 0
        var i = 0

        try {
            i = (id.text.toString()).toInt()
        } catch (exception: NumberFormatException) {
            flag = 1
        }

        var p = 0

        try {
            p = (pret.text.toString()).toInt()
        } catch (exception: NumberFormatException) {
            if(!pret.text.toString().equals("")){
                flag = 1
                pret.setText("pret must be a number")
            }
        }

        val retrofitData: Call<SpectacolItem>

        if (i == 0 || (p == 0 && flag == 1)){
            Toast.makeText(this@UpdateSpectacol, "Could not update spectacol", Toast.LENGTH_SHORT).show()
        }
        else{

            val spectacol1 = SpectacolItem(artisti.text.toString(), data.text.toString(), 0,
                int_orar.text.toString(), p, nume.text.toString(),
                tip_muzica.text.toString())

            retrofitData = retrofitBuilder.updateData(i.toLong(), spectacol1)

            retrofitData.enqueue(object : Callback<SpectacolItem?> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<SpectacolItem?>,
                    response: Response<SpectacolItem?>
                ) {

                    id.setText("")
                    nume.setText("")
                    tip_muzica.setText("")
                    pret.setText("")
                    artisti.setText("")
                    data.setText("")
                    int_orar.setText("")

                    Toast.makeText(this@UpdateSpectacol, "Spectacol has been updated", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<SpectacolItem?>, t: Throwable) {
                    Toast.makeText(this@UpdateSpectacol, "Spectacol has been updated", Toast.LENGTH_SHORT).show()
                    Log.d("UpdateSpectacol", "onFailure: " + t.message)
                }
            })

            val intent = Intent(applicationContext, AdminMenu::class.java)
            startActivity(intent)
        }

    }
}