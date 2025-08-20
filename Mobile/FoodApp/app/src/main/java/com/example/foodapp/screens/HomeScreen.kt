package com.example.foodapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.components.categoriasCards
import com.example.foodapp.components.comidasCards
import com.example.foodapp.components.restaurantesCards
import com.example.foodapp.models.Restaurantes
import com.example.foodapp.models.categoriasLista
import com.example.foodapp.models.comidasLista
import com.example.foodapp.models.restaurantesLista
import com.example.foodapp.ui.theme.myColor
import com.example.foodapp.utils.Account_circle
import com.example.foodapp.utils.Logout

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(15.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Account_circle,
                contentDescription = "Icono de sesion",
                modifier = Modifier.padding(start = 8.dp).size(30.dp),
                tint = myColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Hola, Greys", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Logout,
                contentDescription = "Icono de inicio",
                modifier = Modifier.padding(end = 8.dp).size(30.dp),
                tint = myColor
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(text= "Nuestras Categorias", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            items(categoriasLista){cat ->
                categoriasCards(categorias = cat )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text= "Busca los mejores restaurantes", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp)

        ) {
            items(restaurantesLista){ res ->
                restaurantesCards(restaurantes = res )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text= "Nuestras mejores comidas", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(comidasLista){ com ->
                comidasCards(comidas = com)
            }
        }

    }
}