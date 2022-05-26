package com.example.tema3.model

import retrofit2.Call
import retrofit2.http.GET

interface VanzatorInterface {

    @GET("vanzatori/all")
    fun getData(): Call<List<VanzatorItem>>
}