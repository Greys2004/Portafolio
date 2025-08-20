package com.example.almanzagreysanimalsapp.services

import com.example.almanzagreysanimalsapp.models.Environment
import retrofit2.http.GET

interface environmentsService {
    @GET("Environments")
    suspend fun getEnvironments(): List<Environment>
}