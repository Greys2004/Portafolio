package com.example.barcodeapp.data.dao

import android.provider.SyncStateContract.Helpers.insert
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.barcodeapp.models.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    suspend fun getAllProducts(): List<Product>

    @Query("SELECT * FROM Product WHERE barcode = :barcode")
    suspend fun getProductByBarcode(barcode: String): Product

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)

}