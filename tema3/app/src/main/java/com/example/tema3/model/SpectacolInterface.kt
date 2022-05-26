package com.example.tema3.model

import retrofit2.Call
import retrofit2.http.*

interface SpectacolInterface {

    @GET("spectacole/all")
    fun getData(): Call<List<SpectacolItem>>

    @POST("spectacole/insert")
    fun insertData(@Body spectacol: SpectacolItem): Call<SpectacolItem>

    @DELETE("spectacole/delete/{id}")
    fun deleteData(@Path("id") id: Long): Call<SpectacolItem>

    @PUT("spectacole/update/{id}")
    fun updateData(@Path("id") id: Long, @Body spectacol: SpectacolItem): Call<SpectacolItem>
}