package com.example.tema3.angajat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tema3.BASE_URL
import com.example.tema3.MainActivity
import com.example.tema3.R
import com.example.tema3.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AngajatLogin: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angajatlogin)
        val login = findViewById<Button>(R.id.login3)
        val back = findViewById<Button>(R.id.back12)

        login.setOnClickListener {
            loginAngajat()
        }
        back.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginAngajat() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(AngajatInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        val username = findViewById<EditText>(R.id.user3)
        val password = findViewById<EditText>(R.id.pass3)
        val user = username.text.toString()
        val pass = password.text.toString()

        retrofitData.enqueue(object : Callback<List<AngajatItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<AngajatItem>?>,
                response: Response<List<AngajatItem>?>
            ) {
                val responseBody = response.body()!!

                var gasit1 = 0
                var gasit2 = 0
                var gasit3 = 0


                for(myData in responseBody){
                    if(myData.username.equals(user)){
                        gasit1 = 1
                        break
                    }
                }

                for(myData in responseBody){
                    if(myData.password.equals(pass)){
                        gasit2 = 1
                        break
                    }
                }

                for(myData in responseBody){
                    if(myData.username.equals(user) && myData.password.equals(pass)){
                        gasit3 = 1
                        break
                    }
                }

                if(gasit3 == 1){
                    Toast.makeText(this@AngajatLogin, "LogIn Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, AngajatMenu::class.java)
                    startActivity(intent)
                }
                else if(gasit2 == 1){
                    Toast.makeText(this@AngajatLogin, "Angajat with username " + user + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
                else if(gasit1 == 1){
                    Toast.makeText(this@AngajatLogin, "Angajat with password " + pass + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@AngajatLogin, "Wrong username and password",
                        Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<List<AngajatItem>?>, t: Throwable) {
                Log.d("AngajatLogin", "onFailure: " + t.message)
            }
        })

    }
}