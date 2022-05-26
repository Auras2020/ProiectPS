package com.example.tema3.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface BiletInterface {

    @POST("bilete/creareBilet/film/{idClient}/{idFilm}")
    fun insertBiletFilm(@Path("idClient") idClient: Long, @Path("idFilm") idFilm: Long): Call<BiletItem>

    @POST("bilete/creareBilet/spectacol/{idClient}/{idSpectacol}")
    fun insertBiletSpectacol(@Path("idClient") idClient: Long, @Path("idSpectacol") idSpectacol: Long): Call<SpectacolItem>
}