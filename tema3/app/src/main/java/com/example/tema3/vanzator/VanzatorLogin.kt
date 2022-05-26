package com.example.tema3.vanzator

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

class VanzatorLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vanzatorlogin)
        val login2 = findViewById<Button>(R.id.login2)
        val back2 = findViewById<Button>(R.id.back2)

        login2.setOnClickListener {
            loginVanzator()
        }
        back2.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginVanzator() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(VanzatorInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        val username = findViewById<EditText>(R.id.user2)
        val password = findViewById<EditText>(R.id.pass2)
        val user = username.text.toString()
        val pass = password.text.toString()

        retrofitData.enqueue(object : Callback<List<VanzatorItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<VanzatorItem>?>,
                response: Response<List<VanzatorItem>?>
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
                    Toast.makeText(this@VanzatorLogin, "LogIn Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, VanzatorMenu::class.java)
                    startActivity(intent)
                }
                else if(gasit2 == 1){
                    Toast.makeText(this@VanzatorLogin, "Vanzator with username " + user + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
                else if(gasit1 == 1){
                    Toast.makeText(this@VanzatorLogin, "Vanzator with password " + pass + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@VanzatorLogin, "Wrong username and password",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<VanzatorItem>?>, t: Throwable) {
                Log.d("VanzatorLogin", "onFailure: " + t.message)
            }
        })

    }
}