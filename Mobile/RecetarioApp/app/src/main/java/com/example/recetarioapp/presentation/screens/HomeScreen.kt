    package com.example.recetarioapp.presentation.screens

    import Header
    import android.widget.Toast
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.lazy.LazyRow
    import androidx.compose.foundation.lazy.grid.GridCells
    import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
    import androidx.compose.foundation.lazy.grid.items
    import androidx.compose.foundation.lazy.items
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateListOf
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.hilt.navigation.compose.hiltViewModel
    import androidx.navigation.NavBackStackEntry
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.rememberNavController
    import com.example.recetarioapp.presentation.componets.CategoryCard
    import com.example.recetarioapp.presentation.componets.RecetaCard
    import com.example.recetarioapp.presentation.models.Categoria
    import com.example.recetarioapp.presentation.models.Receta
    import com.example.recetarioapp.presentation.viewModels.RecetaViewModel
    import kotlinx.coroutines.launch

    @Composable
    fun HomeScreen(
        innerPadding: PaddingValues,
        navController: NavHostController,
        viewModel: RecetaViewModel = hiltViewModel()
    ) {
        val context = LocalContext.current

        // Estados locales
        val categorias = remember { mutableStateListOf<Categoria>() }
        val recetas = remember { mutableStateListOf<Receta>() }
        var selectedCategoryId by remember { mutableStateOf<String?>(null) }

        // Recolección de flujos
        LaunchedEffect(Unit) {
            viewModel.obtenerCategorias()
            viewModel.obtenerRecetas()

            launch {
                viewModel.categoriasFlow.collect {
                    categorias.clear()
                    categorias.addAll(it)
                }
            }

            launch {
                viewModel.recetasFlow.collect {
                    recetas.clear()
                    recetas.addAll(it)
                }
            }

            launch {
                viewModel.errorFlow.collect {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            }
        }

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
                        .padding(top = 16.dp, bottom = 16.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    // Título de categorías
                    Text(
                        text = "Categorías",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.DarkGray
                    )

                    LazyRow(
                        modifier = Modifier.padding(top = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        items(categorias) { category ->
                            CategoryCard(
                                category = category,
                                isSelected = selectedCategoryId == category._id,
                                onClick = { selectedCategoryId = category._id }
                            )
                        }
                    }

                    val tituloCategoria = categorias.find { it._id == selectedCategoryId }?.category
                        ?: "Todas las recetas"

                    Text(
                        text = tituloCategoria,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
                    )

                    val recetasFiltradas = if (selectedCategoryId != null) {
                        recetas.filter { it.idcategory == selectedCategoryId }
                    } else {
                        recetas
                    }

                    if (recetasFiltradas.isEmpty()) {
                        Text("No hay recetas disponibles.", color = Color.Gray)
                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(recetasFiltradas) { recipe ->
                                RecetaCard(
                                    recipe = recipe,
                                    categorias = categorias,
                                    onClick = {
                                        navController.navigate("recetaDetail/${recipe._id}")
                                    },
                                    onFavoriteClick = {
                                        viewModel.actualizarFavorito(recipe._id, !recipe.favorite)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun HomeScreenPreview() {
        HomeScreen(
            innerPadding = PaddingValues(0.dp),
            navController = rememberNavController()
        )
    }
