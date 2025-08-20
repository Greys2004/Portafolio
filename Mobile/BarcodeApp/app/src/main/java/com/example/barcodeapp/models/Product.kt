package com.example.barcodeapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Product(
    @PrimaryKey val barcode: String,
    val name: String,
    val price: Double,
    val image : String
)