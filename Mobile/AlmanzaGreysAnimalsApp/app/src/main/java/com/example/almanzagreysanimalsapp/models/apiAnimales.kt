package com.example.almanzagreysanimalsapp.models

import java.io.Serializable


data class Animal(
    val description: String,
    val environmentId: String,
    val facts: List<String>,
    val id: String,
    val image: String,
    val imageGallery: List<String>,
    val name: String
) : Serializable