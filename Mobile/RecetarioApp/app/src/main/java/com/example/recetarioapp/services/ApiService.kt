package com.example.recetarioapp.services

import com.example.recetarioapp.presentation.models.Categoria
import com.example.recetarioapp.presentation.models.Receta
import com.example.recetarioapp.presentation.models.Usuario
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUsuarios(): List<Usuario>

    @GET("recipes")
    suspend fun getRecetas(): List<Receta>

    @GET("categories")
    suspend fun getCategorias(): List<Categoria>

    @POST("/recipes")
    suspend fun postReceta(@Body receta: Receta)

    @PATCH("recipes/{id}")
    suspend fun actualizarRecetaParcial(
        @Path("id") id: String,
        @Body request: FavoritoUpdateRequest
    )

}

data class FavoritoUpdateRequest(
    val favorite: Boolean
)
