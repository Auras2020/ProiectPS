package com.example.tema3.model

import retrofit2.Call
import retrofit2.http.GET

interface ClientInterface {

    @GET("clienti/all")
    fun getData(): Call<List<ClientItem>>
}