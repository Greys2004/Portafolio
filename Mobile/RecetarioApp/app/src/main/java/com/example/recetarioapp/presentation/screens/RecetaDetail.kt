package com.example.recetarioapp.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.recetarioapp.icons.ClockHistory
import com.example.recetarioapp.icons.Fire
import com.example.recetarioapp.icons.Layers
import com.example.recetarioapp.icons.PersonHearts
import com.example.recetarioapp.icons.StarFilled
import com.example.recetarioapp.presentation.viewModels.RecetaViewModel

import java.io.File

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecetaDetail(
    recetaId: String,
    navController: NavHostController,
    viewModel: RecetaViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val recetas by viewModel.recetasFlow.collectAsState(initial = emptyList())
    val receta = recetas.find { it._id == recetaId }

    val categorias by viewModel.categoriasFlow.collectAsState(initial = emptyList())
    val categoriaNombre = categorias.find { it._id == receta?.idcategory }?.category ?: "Sin categoría"


    LaunchedEffect(Unit) {
        viewModel.obtenerRecetas()

        viewModel.errorFlow.collect {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            val imageModel = receta?.image?.let {
                if (it.startsWith("/")) File(it) else it
            } ?: ""

            GlideImage(
                model = imageModel,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                contentScale = ContentScale.Crop
            )

        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(460.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-50).dp),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = Color.White,
            shadowElevation = 4.dp
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(2f)) {
                            Text(
                                text = receta?.name ?: "",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.fillMaxWidth()
                            )

                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    receta?.description?.let {
                        Text(
                            text = it,
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        PillBox(icon = ClockHistory, value = receta?.time ?: "", label = "min")
                        PillBox(icon = PersonHearts, value = receta?.serving ?: "", label = "serving")
                        PillBox(icon = Fire, value = receta?.calories ?: "", label = "Cal")
                        PillBox(icon = Layers, value = receta?.dificulty?:"", label = "Level")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Categoría: $categoriaNombre",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray
                        )
                    }


                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, bottom = 10.dp, top = 10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Ingredientes",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        receta?.ingredients?.forEach { ingrediente ->
                            Row(
                                verticalAlignment = Alignment.Top,
                                modifier = Modifier.padding(bottom = 6.dp)
                            ) {
                                Text("•", fontSize = 16.sp, color = Color.Black, modifier = Modifier.padding(end = 8.dp))
                                Text(ingrediente, fontSize = 15.sp, color = Color.Black)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, bottom = 10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Pasos",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        receta?.pasos?.forEachIndexed { index, paso ->
                            Row(
                                verticalAlignment = Alignment.Top,
                                modifier = Modifier.padding(bottom = 8.dp)
                            ) {
                                Text(
                                    text = "${index + 1}.",
                                    fontSize = 16.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Text(
                                    text = paso,
                                    fontSize = 15.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }
}

@Composable
fun PillBox(icon: ImageVector, value: String, label: String) {
    Box(
        modifier = Modifier
            .width(70.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(75.dp))
            .background(color = Color(0xFFFFC107))
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xFFffd863)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = icon,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy((-6).dp)
            ) {
                Text(
                    text = value,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Text(
                    text = label,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    fontSize = 11.sp
                )
            }
        }
    }
}


