package com.example.barcodeapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.barcodeapp.data.dao.ProductDao
import com.example.barcodeapp.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}