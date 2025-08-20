package com.example.foodapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodapp.models.Categorias
import com.example.foodapp.models.categoriasLista
import com.example.foodapp.ui.theme.FoodAppTheme
import com.example.foodapp.ui.theme.myColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun categoriasCards(categorias: Categorias){

    Column(
        modifier = Modifier.padding(8.dp)
    ){
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(myColor),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                model = categorias.imagen,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = categorias.nombre,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun categoriasCardPreview(){
    FoodAppTheme{
        categoriasCards(categorias = categoriasLista[0])
    }
}