package com.example.recetarioapp.presentation.screens

import Header
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.recetarioapp.presentation.componets.FavoriteCard
import com.example.recetarioapp.presentation.models.Categoria
import com.example.recetarioapp.presentation.models.Receta
import com.example.recetarioapp.presentation.viewModels.RecetaViewModel
import kotlinx.coroutines.launch

@Composable
fun FavoritesScreens(
    innerPadding: PaddingValues,
    navController: NavHostController,
    viewModel: RecetaViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val recetas = remember { mutableStateListOf<Receta>() }
    val categorias = remember { mutableStateListOf<Categoria>() }

    // Cargar recetas al entrar
    LaunchedEffect(Unit) {
        viewModel.obtenerRecetas()
        viewModel.obtenerCategorias()

        launch {
            viewModel.categoriasFlow.collect { lista ->
                categorias.clear()
                categorias.addAll(lista)
            }
        }

        launch{
            viewModel.recetasFlow.collect { lista ->
                recetas.clear()
                recetas.addAll(lista)
            }
        }
    }

    LaunchedEffect(true) {
        viewModel.errorFlow.collect {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    val favoritas = recetas.filter { it.favorite }

    Box(modifier = Modifier.fillMaxSize()) {
        Header()
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 160.dp),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = Color.White,
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Favoritos",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                if (favoritas.isEmpty()) {
                    Text("No hay recetas favoritas.", color = Color.Gray)
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(favoritas) { receta ->
                            FavoriteCard(
                                recipe = receta,
                                categorias = categorias,
                                onActionClick = {
                                    navController.navigate("recetaDetail/${receta._id}")
                                },
                                onFavoriteClick = {
                                    viewModel.actualizarFavorito(receta._id, !receta.favorite)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}




