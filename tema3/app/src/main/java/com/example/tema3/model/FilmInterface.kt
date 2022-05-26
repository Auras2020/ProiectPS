package com.example.tema3.model

import retrofit2.Call
import retrofit2.http.*


interface FilmInterface {

    @GET("filme/all")
    fun getData(): Call<List<FilmItem>>

    @POST("filme/insert")
    fun insertData(@Body film: FilmItem): Call<FilmItem>

    @DELETE("filme/delete/{id}")
    fun deleteData(@Path("id") id: Long): Call<FilmItem>

    @PUT("filme/update/{id}")
    fun updateData(@Path("id") id: Long, @Body film: FilmItem): Call<FilmItem>
}