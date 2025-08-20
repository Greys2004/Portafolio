package com.example.almanzagreysanimalsapp.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.almanzagreysanimalsapp.models.Animal
import com.example.almanzagreysanimalsapp.services.animalesService
import com.example.almanzagreysanimalsapp.ui.theme.AlmanzaGreysAnimalsAppTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun listaAnimales(innerPadding: PaddingValues, onAnimalClick: (Animal) -> Unit) {
    var animales by remember {
        mutableStateOf<List<Animal>?>(null)
    }

    val scope = rememberCoroutineScope()
    val BASE_URL = "https://animals.juanfrausto.com/api/"

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val animalesServie = retrofit.create(animalesService::class.java)
                animales = animalesServie.getAnimales()
                Log.d("APIII", "Se recibieron ${animales} animales")


            } catch (e: Exception) {
                Log.e("listaAnimales", e.toString())
            }
        }
    }


    animales?.let { lista ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color(0xFF2f3a30)
            )

        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Animales",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White
                    )
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFf3f8a4).copy(alpha = 0.9f)),
                    ) {
                        Icon(
                            Icons.Default.AddCircle,
                            contentDescription = "Agregar",
                            tint = Color.Black
                        )
                        Text(
                            "Agregar",
                            color = Color.Black
                        )
                    }
                }
                Text(
                    "Conoce a los animales más increíbles del mundo",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            // Lista de animales
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(lista) { animal ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onAnimalClick(animal) }
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(animal.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(160.dp)
                                .padding(8.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            animal.name,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}



@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun listaAnimalesPreview() {
    AlmanzaGreysAnimalsAppTheme {
        listaAnimales(
            innerPadding = PaddingValues(10.dp),
            onAnimalClick = TODO()
        )
    }
}