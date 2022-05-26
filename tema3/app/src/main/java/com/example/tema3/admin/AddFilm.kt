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
import com.example.tema3.model.FilmInterface
import com.example.tema3.model.FilmItem
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AddFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addfilm)
        val add = findViewById<Button>(R.id.addfilm)
        val back = findViewById<Button>(R.id.back5)
        add.setOnClickListener {
            process()
        }
        back.setOnClickListener {
            val intent = Intent(applicationContext, AdminMenuExtins::class.java)
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
            .create(FilmInterface::class.java)

        val nume = findViewById<EditText>(R.id.nume)
        val gen = findViewById<EditText>(R.id.gen)
        val varsta = findViewById<EditText>(R.id.varsta)
        val tip = findViewById<EditText>(R.id.tip)
        val data = findViewById<EditText>(R.id.data)
        val capacitate = findViewById<EditText>(R.id.capacitate)
        val pret = findViewById<EditText>(R.id.pret)
        val regizor = findViewById<EditText>(R.id.regizor)
        val actori = findViewById<EditText>(R.id.actori)

        var c = 0

        try {
            c = (capacitate.text.toString()).toInt()
        } catch (exception: NumberFormatException) {
            capacitate.setTextColor(R.color.red)
            capacitate.setText("capacitate must be a number")
        }

        var p = 0

        try {
            p = (pret.text.toString()).toInt()
        } catch (exception: NumberFormatException) {
            pret.setTextColor(R.color.red)
            pret.setText("pret must be a number")
        }

        var v = 0

        try {
            v = (varsta.text.toString()).toInt()
        } catch (exception: NumberFormatException) {
            varsta.setTextColor(R.color.red)
            varsta.setText("varsta must be a number")
        }

        if(actori.text.toString().equals("")){
            actori.setText("actori must have a value")
        }
        if(data.text.toString().equals("")){
            data.setText("data must have a value")
        }
        if(gen.text.toString().equals("")){
            gen.setText("gen must have a value")
        }
        if(nume.text.toString().equals("")){
            nume.setText("nume must have a value")
        }
        if(regizor.text.toString().equals("")){
            regizor.setText("regizor must have a value")
        }
        if(tip.text.toString().equals("")){
            tip.setText("tip must have a value")
        }

        val retrofitData: Call<FilmItem>

        if (c == 0 || v == 0 || p == 0 || actori.text.toString().equals("") || data.text.toString().equals("") ||
            gen.text.toString().equals("") || nume.text.toString().equals("") || regizor.text.toString().equals("") ||
            tip.text.toString().equals("")){
                Toast.makeText(this@AddFilm, "Could not add film", Toast.LENGTH_SHORT).show()
                //val intent = Intent(applicationContext, AddFilm::class.java)
                //startActivity(intent)
        }
        else {
            val film1 = FilmItem(actori.text.toString(), c, data.text.toString(),
                gen.text.toString(), 0, nume.text.toString(), p, regizor.text.toString(),
                tip.text.toString(), v)

            retrofitData = retrofitBuilder.insertData(film1)

            retrofitData.enqueue(object : Callback<FilmItem?> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<FilmItem?>,
                    response: Response<FilmItem?>
                ) {

                    nume.setText("")
                    gen.setText("")
                    varsta.setText("")
                    tip.setText("")
                    data.setText("")
                    capacitate.setText("")
                    pret.setText("")
                    regizor.setText("")
                    actori.setText("")
                    capacitate.setTextColor(R.color.black)
                    pret.setTextColor(R.color.black)
                    varsta.setTextColor(R.color.black)

                    Toast.makeText(this@AddFilm, "Film has been added", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<FilmItem?>, t: Throwable) {
                    Toast.makeText(this@AddFilm, "Film has been added", Toast.LENGTH_SHORT).show()
                    Log.d("AddFilm", "onFailure: " + t.message)
                }
            })

            val intent = Intent(applicationContext, AdminMenu::class.java)
            startActivity(intent)
        }

    }
}