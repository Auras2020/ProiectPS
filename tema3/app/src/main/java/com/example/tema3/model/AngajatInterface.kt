package com.example.tema3.model

import retrofit2.Call
import retrofit2.http.GET

interface AngajatInterface {

    @GET("angajati/all")
    fun getData(): Call<List<AngajatItem>>
}