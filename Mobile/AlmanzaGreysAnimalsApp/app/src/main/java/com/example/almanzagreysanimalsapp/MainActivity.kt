package com.example.almanzagreysanimalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.almanzagreysanimalsapp.models.Animal
import com.example.almanzagreysanimalsapp.models.Environment
import com.example.almanzagreysanimalsapp.screens.detalleAmbiente
import com.example.almanzagreysanimalsapp.screens.detalleAnimal
import com.example.almanzagreysanimalsapp.screens.listaAmbientes
import com.example.almanzagreysanimalsapp.screens.listaAnimales
import com.example.almanzagreysanimalsapp.ui.theme.AlmanzaGreysAnimalsAppTheme
import com.example.almanzagreysanimalsapp.utils.Cat
import com.example.almanzagreysanimalsapp.utils.Tree

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlmanzaGreysAnimalsAppTheme {

                var selectedScreen by remember {
                    mutableStateOf("animales")
                }

                val navController = rememberNavController()


                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF2f3a30)),
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent,

                    bottomBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = Color(0xFFF3F8A4).copy(alpha = 0.8f),
                                shadowElevation = 8.dp
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(horizontal = 24.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                                ) {
                                    NavigationBarItem(
                                        selected = selectedScreen == "animales",
                                        onClick = {
                                            selectedScreen = "animales"
                                            navController.navigate("animales")
                                        },
                                        icon = {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Cat,
                                                    tint = Color.Black,
                                                    contentDescription = "Inicio",
                                                    modifier = Modifier.size(20.dp)
                                                )
                                                Text(
                                                    text = "Inicio",
                                                    color = Color.Black,
                                                    fontSize = 14.sp
                                                )
                                            }
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.Transparent // sin resaltado
                                        ),
                                        alwaysShowLabel = false
                                    )

                                    NavigationBarItem(
                                        selected = selectedScreen == "ambientes",
                                        onClick = {
                                            selectedScreen = "ambientes"
                                            navController.navigate("ambientes")
                                        },
                                        icon = {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Tree,
                                                    tint = Color.Black,
                                                    contentDescription = "Ambientes",
                                                    modifier = Modifier.size(20.dp)
                                                )
                                                Text(
                                                    text = "Ambientes",
                                                    color = Color.Black,
                                                    fontSize = 14.sp
                                                )
                                            }
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.Transparent
                                        ),
                                        alwaysShowLabel = false
                                    )
                                }
                            }
                        }
                    }


                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "animales") {

                        //OnClick
                        composable(route = "animales") {
                            listaAnimales(innerPadding = innerPadding) { selectedAnimal ->
                                navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.set("animal", selectedAnimal)
                                navController.navigate("detalleAnimal")
                            }
                        }

                        composable("detalleAnimal") {
                            val animall = navController.previousBackStackEntry
                                ?.savedStateHandle
                                ?.get<Animal>("animal")

                            if (animall != null) {
                                detalleAnimal(animal = animall, innerPadding = innerPadding)
                            }
                        }

                        //OnClick
                        composable(route = "ambientes") {
                            listaAmbientes(innerPadding = innerPadding) { selectedAmbiente, animalesList ->
                                navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.set("ambiente", selectedAmbiente)

                                navController.currentBackStackEntry
                                    ?.savedStateHandle
                                    ?.set("animales", animalesList)

                                navController.navigate("detalleAmbiente")
                            }
                        }

                        composable("detalleAmbiente") {
                            val ambiente = navController.previousBackStackEntry
                                ?.savedStateHandle
                                ?.get<Environment>("ambiente")

                            val animales = navController.previousBackStackEntry
                                ?.savedStateHandle
                                ?.get<List<Animal>>("animales")

                            if (ambiente != null && animales != null) {
                                detalleAmbiente(
                                    ambiente = ambiente,
                                    animales = animales,
                                    innerPadding = innerPadding,
                                    onAnimalClick = { selectedAnimal ->
                                        navController.currentBackStackEntry
                                            ?.savedStateHandle
                                            ?.set("animal", selectedAnimal)
                                        navController.navigate("detalleAnimal")
                                    }
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlmanzaGreysAnimalsAppTheme {
        Greeting("Android")
    }
}