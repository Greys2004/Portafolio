package com.example.foodapp.models

data class Comidas(
    val id : Int,
    val nombre : String,
    val imagen : String,
    val calificacion : Double,
    val precio : Double
)

val comidasLista = listOf(
    Comidas(
        id = 1,
        nombre = "California Roll",
        imagen = "https://png.pngtree.com/png-clipart/20240903/original/pngtree-artful-cuisine-the-world-of-sushi-dishes-png-image_15924763.png",
        calificacion = 9.5,
        precio = 120.00
    ),
    Comidas(
        id = 2,
        nombre = "Rockstar Burger",
        imagen = "https://static.vecteezy.com/system/resources/previews/022/911/694/non_2x/cute-cartoon-burger-icon-free-png.png",
        calificacion = 9.2,
        precio = 95.00
    ),
    Comidas(
        id = 3,
        nombre = "McFlurry",
        imagen = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIE7VgNP5X0cgkB9QHbcsOQduCRjdmDgTaBG3gQm_t_Fxt51lRGO92JYViflQ836U9I1A&usqp=CAU",
        calificacion = 9.0,
        precio = 35.50
    ),
    Comidas(
        id = 4,
        nombre = "Cappucchino",
        imagen = "https://static.vecteezy.com/system/resources/previews/045/621/261/non_2x/cold-drink-milkshake-isolated-png.png",
        calificacion = 9.5,
        precio = 99.90
    ),
    Comidas(
        id = 5,
        nombre = "Ke banquete",
        imagen = "https://pngimg.com/d/kfc_food_PNG29.png",
        calificacion = 9.1,
        precio = 190.50
    ),
    Comidas(
        id = 6,
        nombre = "Malteada chocolate",
        imagen = "https://carlsjr.es/wp-content/uploads/2023/03/American_Shake_Chocolate-500x500px.png",
        calificacion = 9.8,
        precio = 85.75
    ),
)