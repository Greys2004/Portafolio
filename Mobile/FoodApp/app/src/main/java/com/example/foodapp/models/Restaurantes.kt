package com.example.foodapp.models

data class Restaurantes(
    val id : Int,
    val nombre : String,
    val imagen : String
)

val restaurantesLista = listOf(
    Restaurantes(
        id = 1,
        nombre = "Burger King",
        imagen = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0Xc228_zSp0Uk3xtCqLZvDiyUYgYeIkvXTg&s",
    ),
    Restaurantes(
        id = 2,
        nombre = "Starbucks",
        imagen = "https://shadefx.com/wp-content/uploads/2024/10/Starbucks-Logo.png",
    ),
    Restaurantes(
        id = 3,
        nombre = "KFC",
        imagen = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbqjPqjigJwHu4VvBHRbIMuIO7TD9qgiE-kw&s",
    ),
    Restaurantes(
        id = 4,
        nombre = "Dairy Queen",
        imagen = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Dairy_Queen_logo.svg/2560px-Dairy_Queen_logo.svg.png",
    ),
    Restaurantes(
        id = 5,
        nombre = "Little Caesars",
        imagen = "https://logos-world.net/wp-content/uploads/2022/02/Little-Caesars-Emblem.png",
    ),
    Restaurantes(
        id = 6,
        nombre = "Carls Jr.",
        imagen = "https://logos-world.net/wp-content/uploads/2022/11/Carls-Jr.-Symbol.png",
    ),
)