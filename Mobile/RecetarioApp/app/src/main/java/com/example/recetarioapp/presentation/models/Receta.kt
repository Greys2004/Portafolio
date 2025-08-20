package com.example.recetarioapp.presentation.models

data class Receta(
    val __v: Int,
    val _id: String,
    val calories: String,
    val description: String,
    val dificulty: String,
    val favorite: Boolean,
    val idcategory: String,
    val image: String,
    val ingredients: List<String>,
    val name: String,
    val pasos: List<String>,
    val serving: String,
    val time: String
)