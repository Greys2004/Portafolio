package com.example.almanzagreysanimalsapp.models

import java.io.Serializable

data class Environment(
    val _id: String,
    val description: String,
    val image: String,
    val name: String
) : Serializable