package com.example.recetarioapp.presentation.models

import android.media.Image

data class Category(
    val name: String,
    val imageUrl: String
)

val CategoriyList= listOf(
    Category("Fast Food", "https://cdn-icons-png.flaticon.com/512/2819/2819194.png"),
    Category("Chinese", "https://cdn-icons-png.flaticon.com/512/1400/1400695.png"),
    Category("Italian", "https://images.vexels.com/media/users/3/220450/isolated/preview/984a6e47ce1687660201e8e687ac28f2-farfalle-pasta-dish-illustration.png"),
    Category("Mexican", "https://cdn-icons-png.freepik.com/512/6313/6313541.png"),
    Category("Desserts", "https://cdn4.iconfinder.com/data/icons/desserts-around-the-globe/100/Dessert_Icons_Pudding-512.png")
)

