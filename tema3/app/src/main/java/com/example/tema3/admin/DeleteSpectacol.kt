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

class DeleteSpectacol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletespectacol)
        val del = findViewById<Button>(R.id.deletespectacol)
        val back = findViewById<Button>(R.id.back5)
        del.setOnClickListener {
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

        val id = findViewById<EditText>(R.id.id1)

        var flag = 0
        var i = 0

        try {
            i = (id.text.toString()).toInt()
        } catch (exception: NumberFormatException) {
            flag = 1
        }

        val retrofitData: Call<SpectacolItem>

        if (i == 0 || flag == 1){
            Toast.makeText(this@DeleteSpectacol, "Could not delete spectacol", Toast.LENGTH_SHORT).show()
            //val intent = Intent(applicationContext, AddFilm::class.java)
            //startActivity(intent)
        }
        else {

            retrofitData = retrofitBuilder.deleteData(i.toLong())

            retrofitData.enqueue(object : Callback<SpectacolItem?> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<SpectacolItem?>,
                    response: Response<SpectacolItem?>
                ) {

                    id.setText("")
                    Toast.makeText(this@DeleteSpectacol, "Spectacol could not be deleted", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<SpectacolItem?>, t: Throwable) {
                    Toast.makeText(this@DeleteSpectacol, "Spectacol has been deleted", Toast.LENGTH_SHORT).show()
                    Log.d("DeleteSpectacol", "onFailure: " + t.message)
                }
            })

            val intent = Intent(applicationContext, AdminMenu::class.java)
            startActivity(intent)
        }

    }
}