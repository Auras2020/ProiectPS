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
import com.example.tema3.MainActivity
import com.example.tema3.R
import com.example.tema3.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var clientId = 0
var numClient = ""
var nrBil = 0
var listBilete = mutableListOf<BiletItem>()
var s1 = 0
var s2 = 0
var s = 0

class ClientLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientlogin)
        val login1 = findViewById<Button>(R.id.login1)
        val back1 = findViewById<Button>(R.id.back1)

        login1.setOnClickListener {
            loginClient()
        }
        back1.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginClient() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ClientInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        val username = findViewById<EditText>(R.id.user1)
        val password = findViewById<EditText>(R.id.pass1)
        val user = username.text.toString()
        val pass = password.text.toString()

        retrofitData.enqueue(object : Callback<List<ClientItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<ClientItem>?>,
                response: Response<List<ClientItem>?>
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
                        clientId = myData.id
                        gasit3 = 1
                        break
                    }
                }

                if(gasit3 == 1){

                    val retrofitBuilder2 = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()
                        .create(ClientInterface::class.java)

                    val retrofitData2 = retrofitBuilder2.getData()

                    retrofitData2.enqueue(object : Callback<List<ClientItem>?> {
                        @SuppressLint("NotifyDataSetChanged")
                        override fun onResponse(
                            call: Call<List<ClientItem>?>,
                            response: Response<List<ClientItem>?>
                        ) {
                            val responseBody2 = response.body()!!

                            for(myData in responseBody2){
                                if(myData.id == clientId){
                                    numClient = myData.nume
                                    break
                                }
                            }
                        }
                        override fun onFailure(call: Call<List<ClientItem>?>, t: Throwable) {
                            Log.d("Client", "onFailure: " + t.message)
                        }
                    })

                    Toast.makeText(this@ClientLogin, "LogIn Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, ClientMenu::class.java)
                    startActivity(intent)
                }
                else if(gasit2 == 1){
                    Toast.makeText(this@ClientLogin, "Client with username " + user + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
                else if(gasit1 == 1){
                    Toast.makeText(this@ClientLogin, "Client with password " + pass + " does not exist",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@ClientLogin, "Wrong username and password",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ClientItem>?>, t: Throwable) {
                Log.d("ClientLogin", "onFailure: " + t.message)
            }
        })

    }
}