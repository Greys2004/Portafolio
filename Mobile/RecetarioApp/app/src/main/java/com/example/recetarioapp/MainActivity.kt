package com.example.recetarioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.*
import com.example.recetarioapp.presentation.screens.AddScreen
import com.example.recetarioapp.presentation.screens.FavoritesScreens
import com.example.recetarioapp.presentation.screens.HomeScreen
import com.example.recetarioapp.presentation.screens.RecetaDetail
import com.example.recetarioapp.presentation.ui.theme.RecetarioAppTheme
import com.example.recetarioapp.presentation.utils.Bookmark
import com.example.recetarioapp.presentation.utils.Home
import com.example.recetarioapp.presentation.viewModels.RecetaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RecetarioAppTheme {
                val navController = rememberNavController()
                var selectedScreen by remember { mutableStateOf("home") }

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    bottomBar = {
                        NavigationBar(
                            containerColor = Color.White,
                            modifier = Modifier.height(56.dp)
                        ) {
                            NavigationBarItem(
                                selected = selectedScreen == "home",
                                onClick = {
                                    selectedScreen = "home"
                                    navController.navigate("home") {
                                        popUpTo(0)
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = Home,
                                        contentDescription = "Inicio",
                                        tint = if (selectedScreen == "home") Color.Black else Color.Gray
                                    )
                                },
                                label = { Text("Inicio") }
                            )

                            NavigationBarItem(
                                selected = selectedScreen == "add",
                                onClick = {
                                    selectedScreen = "add"
                                    navController.navigate("add") {
                                        popUpTo(0)
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Agregar",
                                        tint = if (selectedScreen == "add") Color.Black else Color.Gray
                                    )
                                },
                                label = { Text("Agregar") }
                            )

                            NavigationBarItem(
                                selected = selectedScreen == "favorites",
                                onClick = {
                                    selectedScreen = "favorites"
                                    navController.navigate("favorites") {
                                        popUpTo(0)
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = Bookmark,
                                        contentDescription = "Favoritos",
                                        tint = if (selectedScreen == "favorites") Color.Black else Color.Gray
                                    )
                                },
                                label = { Text("Favoritos") }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            HomeScreen(innerPadding = innerPadding, navController = navController)
                        }

                        composable("add") {
                            val recetaViewModel: RecetaViewModel = hiltViewModel()

                            AddScreen(
                                navController = navController,
                                innerPadding = innerPadding,
                                viewModel = recetaViewModel
                            )
                        }

                        composable("favorites") {
                            FavoritesScreens(
                                innerPadding = innerPadding,
                                navController = navController
                            )
                        }

                        composable("recetaDetail/{id}") { backStackEntry ->
                            val recetaId = backStackEntry.arguments?.getString("id") ?: ""
                            RecetaDetail(recetaId = recetaId, navController = navController)
                        }

                        }



                    }
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecetarioAppTheme {
    }
}