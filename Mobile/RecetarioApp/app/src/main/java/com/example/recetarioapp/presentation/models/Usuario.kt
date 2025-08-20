package com.example.recetarioapp.presentation.models

data class Usuario(
    val __v: Int,
    val _id: String,
    val favorits: List<String>,
    val image: String,
    val password: String,
    val username: String
)