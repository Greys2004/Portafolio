package com.example.almanzagreysanimalsapp.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
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
import com.example.almanzagreysanimalsapp.models.Environment
import com.example.almanzagreysanimalsapp.services.animalesService
import com.example.almanzagreysanimalsapp.services.environmentsService
import com.example.almanzagreysanimalsapp.ui.theme.AlmanzaGreysAnimalsAppTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun listaAmbientes(innerPadding: PaddingValues, onAnimalClick: (Environment, List<Animal>) -> Unit) {
    var ambientes by remember {
        mutableStateOf<List<Environment>?>(null)
    }

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

                val environmentsService = retrofit.create(environmentsService::class.java)
                ambientes = environmentsService.getEnvironments()

                val animalesService = retrofit.create(animalesService::class.java)
                animales = animalesService.getAnimales()

                Log.d("APIII", "Se recibieron ${ambientes} animales")


            } catch (e: Exception) {
                Log.e("listaAmbientes", e.toString())
            }
        }
    }


    ambientes?.let { lista ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                "Ambientes",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(lista) { ambiente ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onAnimalClick(ambiente, animales!!) }
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(ambiente.image),
                            contentDescription = ambiente.name,
                            modifier = Modifier
                                .size(160.dp)
                                .padding(8.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            ambiente.name,
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
fun listaAmbientesPreview() {
    AlmanzaGreysAnimalsAppTheme {
        listaAmbientes(
            innerPadding = PaddingValues(10.dp),
            onAnimalClick = TODO()
        )
    }
}