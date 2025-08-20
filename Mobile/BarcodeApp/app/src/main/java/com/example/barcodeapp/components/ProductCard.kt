package com.example.barcodeapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.barcodeapp.models.Product
import com.example.barcodeapp.utils.products

@Composable
fun ProductCard(product: Product){
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Text(
                text  = product.name,
                modifier = Modifier.weight(1f),
                color = Color(0xFFE91E63),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${product.price}",
                modifier = Modifier.padding(end = 10.dp),
                color = Color(0xFFE91E63),

            )
        }
    }
}

@Preview
@Composable
fun ProductCardPreview(){
    ProductCard(product = products[0])
}