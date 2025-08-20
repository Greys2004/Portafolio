package com.example.foodapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodapp.models.Categorias
import com.example.foodapp.models.Comidas
import com.example.foodapp.ui.theme.myColor
import com.example.foodapp.utils.Account_circle
import com.example.foodapp.utils.Star

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun comidasCards(comidas: Comidas){

    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                model = comidas.imagen,
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(myColor)
                    .align(Alignment.BottomEnd),

                ) {
                Text(
                    text = "$${String.format("%.2f", comidas.precio)}",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),

                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),

        ){
            Icon(
                imageVector = Star,
                contentDescription = "Icono de sesion",
                modifier = Modifier.size(25.dp),
                tint = Color.Green
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text( text = comidas.calificacion.toString(), fontSize = 14.sp )
            Spacer(modifier = Modifier.width(2.dp))
            Text( text = comidas.nombre, fontSize = 14.sp)
        }
    }
}