package com.example.recetarioapp.presentation.screens

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.rememberAsyncImagePainter
import com.example.recetarioapp.presentation.models.Categoria
import com.example.recetarioapp.presentation.models.Receta
import com.example.recetarioapp.presentation.viewModels.RecetaViewModel

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


@Composable
fun AddScreen(
    navController: NavHostController,
    viewModel: RecetaViewModel,
    innerPadding: PaddingValues
) {
    val context = LocalContext.current
    val categorias = viewModel.categoriasFlow.collectAsState(initial = emptyList()).value
    val dificultades = listOf("Fácil", "Media", "Difícil")

    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }
    var serving by remember { mutableStateOf("") }
    var dificulty by remember { mutableStateOf("") } // <-- NUEVO
    var selectedCategoryId by remember { mutableStateOf<String?>(null) }
    var ingredientsText by remember { mutableStateOf("") }
    var pasosText by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        imageUri = it
    }

    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { Text("Agregar nueva receta", style = MaterialTheme.typography.titleLarge) }

        item {
            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
        }

        item {
            OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Descripción") }, modifier = Modifier.fillMaxWidth())
        }

        item {
            OutlinedTextField(value = time, onValueChange = { time = it }, label = { Text("Tiempo (min)") }, modifier = Modifier.fillMaxWidth())
        }

        item {
            OutlinedTextField(value = calories, onValueChange = { calories = it }, label = { Text("Calorías") }, modifier = Modifier.fillMaxWidth())
        }

        item {
            OutlinedTextField(value = serving, onValueChange = { serving = it }, label = { Text("Porciones") }, modifier = Modifier.fillMaxWidth())
        }

        item {
            DropdownMenuSimple(
                options = dificultades,
                selectedOption = dificulty,
                label = "Dificultad",
                onSelected = { dificulty = it }
            )
        }


        item {
            Button(onClick = { launcher.launch("image/*") }) {
                Text("Seleccionar imagen")
            }
        }

        item {
            imageUri?.let { uri ->
                Image(
                    painter = rememberAsyncImagePainter(model = uri),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }

        item {
            OutlinedTextField(
                value = ingredientsText,
                onValueChange = { ingredientsText = it },
                label = { Text("Ingredientes (separados por coma)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            OutlinedTextField(
                value = pasosText,
                onValueChange = { pasosText = it },
                label = { Text("Pasos (separados por coma)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            DropdownMenuCategory(
                categorias = categorias,
                selectedId = selectedCategoryId,
                onSelected = { selectedCategoryId = it }
            )
        }

        item {
            Button(
                onClick = {
                    if (name.isNotBlank() && selectedCategoryId != null) {
                        // Guardar imagen localmente
                        val savedImagePath = imageUri?.let { uri ->
                            try {
                                val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
                                val file = File(context.filesDir, "imagen_${System.currentTimeMillis()}.jpg")
                                val outputStream = FileOutputStream(file)
                                inputStream?.copyTo(outputStream)
                                outputStream.close()
                                inputStream?.close()
                                file.absolutePath // ruta local
                            } catch (e: Exception) {
                                e.printStackTrace()
                                null
                            }
                        } ?: ""

                        val receta = Receta(
                            _id = "",
                            __v = 0,
                            name = name,
                            description = description,
                            time = time,
                            calories = calories,
                            serving = serving,
                            dificulty = dificulty ?: "",
                            image = savedImagePath,
                            idcategory = selectedCategoryId!!,
                            ingredients = ingredientsText.split(",").map { it.trim() },
                            pasos = pasosText.split(",").map { it.trim() },
                            favorite = false
                        )

                        viewModel.agregarReceta(receta)
                        viewModel.obtenerRecetas()
                        navController.navigateUp()
                        Toast.makeText(context, "Receta guardada", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Faltan campos obligatorios", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar receta")
            }
        }
    }
}

@Composable
fun DropdownMenuCategory(
    categorias: List<Categoria>,
    selectedId: String?,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = categorias.find { it._id == selectedId }?.category ?: "",
            onValueChange = {},
            readOnly = true,
            label = { Text("Categoría") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            categorias.forEach { categoria ->
                DropdownMenuItem(
                    text = { Text(categoria.category) },
                    onClick = {
                        onSelected(categoria._id)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun DropdownMenuSimple(
    options: List<String>,
    selectedOption: String?,
    label: String,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selectedOption ?: "",
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
