package com.example.almanzagreysanimalsapp.services

import com.example.almanzagreysanimalsapp.models.Animal
import retrofit2.http.GET

interface animalesService {
    //EndPoint
    @GET("Animals")
    suspend fun getAnimales(): List<Animal>
}