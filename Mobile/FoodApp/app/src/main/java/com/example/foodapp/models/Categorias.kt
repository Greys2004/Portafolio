package com.example.foodapp.models

import java.util.Date

data class Categorias(
    val id : Int,
    val nombre : String,
    val imagen : String
)

val categoriasLista = listOf(
    Categorias(
        id = 1,
        nombre = "Italiana",
        imagen = "https://png.pngtree.com/png-clipart/20231003/original/pngtree-italian-pizza-pixelated-food-png-image_13229938.png",
    ),
    Categorias(
        id = 2,
        nombre = "China",
        imagen = "https://www.pixz.com.mx/images/product/Caja_Comida_China_G32.png",
    ),
    Categorias(
        id = 3,
        nombre = "Comida Rápida",
        imagen = "https://png.pngtree.com/png-clipart/20240314/original/pngtree-fast-food-meal-png-with-ai-generated-png-image_14589129.png",
    ),
    Categorias(
        id = 4,
        nombre = "Postres",
        imagen = "https://static.vecteezy.com/system/resources/previews/025/138/075/non_2x/chocolate-brownie-fudge-chocolate-bar-truvia-recipe-frozen-dessert-cake-generative-ai-free-png.png",
    ),
    Categorias(
        id = 5,
        nombre = "Bebidas",
        imagen = "https://static.vecteezy.com/system/resources/previews/046/592/156/non_2x/cocktails-beverages-illustration-watercolor-style-png.png",
    ),
    Categorias(
        id = 6,
        nombre = "Mexicana",
        imagen = "https://png.pngtree.com/png-vector/20240801/ourmid/pngtree-savory-mexican-street-tacos-traditional-with-spicy-salsa-isolated-transparent-background-png-image_13321393.png",
    ),
)