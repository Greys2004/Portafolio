package com.example.almanzagreysanimalsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.almanzagreysanimalsapp.models.Animal
import com.example.almanzagreysanimalsapp.models.Environment

@Composable
fun detalleAmbiente(
    ambiente: Environment,
    animales: List<Animal>,
    innerPadding: PaddingValues,
    onAnimalClick: (Animal) -> Unit
) {
    val animalesDelAmbiente = animales.filter { it.environmentId == ambiente._id }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = ambiente.name,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(0xFFe7ec9d)
                )

                Image(
                    painter = rememberAsyncImagePainter(ambiente.image),
                    contentDescription = ambiente.name,
                    modifier = Modifier
                        .size(240.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = ambiente.description,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Animales en este ambiente:",
                    style = MaterialTheme.typography.headlineMedium.copy(color = Color(0xFFe7ec9d)),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }

        items(animalesDelAmbiente) { animal ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onAnimalClick(animal)}
            ) {
                Image(
                    painter = rememberAsyncImagePainter(animal.image),
                    contentDescription = animal.name,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = animal.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}