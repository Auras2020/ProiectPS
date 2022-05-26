package com.example.tema3.model

data class ClientItem(
    val certificatVerde: String,
    val films: List<Any>,
    val id: Int,
    val nume: String,
    val password: String,
    val spectacole: List<Any>,
    val username: String,
    val varsta: Int
)