package com.example.recetarioapp.presentation.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.example.recetarioapp.presentation.models.Categoria
import com.example.recetarioapp.presentation.models.Category


@Composable
fun CategoryCard(
    category: Categoria,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color(0xFFFFC107) else Color(0xFFF2F2F2)
    val textColor = if (isSelected) Color.Black else Color.Gray

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .width(56.dp)
                .height(72.dp)
                .background(backgroundColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = category.image,
                contentDescription = category.category,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = category.category,
            color = textColor,
            fontSize = 13.sp
        )
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewCategoryCard() {
}