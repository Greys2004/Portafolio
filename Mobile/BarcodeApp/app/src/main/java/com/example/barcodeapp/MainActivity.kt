package com.example.barcodeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.barcodeapp.components.ProductCard
import com.example.barcodeapp.data.dao.ProductDao
import com.example.barcodeapp.data.database.AppDatabase
import com.example.barcodeapp.models.Product
import com.example.barcodeapp.ui.theme.BarcodeAppTheme
import com.example.barcodeapp.utils.products
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "product_store"
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarcodeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(innerPadding = innerPadding, dao = db.productDao())
                }
            }
        }
    }
}

@Composable
fun HomeScreen(innerPadding: PaddingValues, dao: ProductDao) {
    


    var scanResult by remember {
        mutableStateOf<String?>(null)
    }
    val productsScanned = remember {
        mutableStateListOf<Product>()
    }

    val scope = rememberCoroutineScope()

    val scanLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
    ){
        result ->
        val barcode = result.data?.getStringExtra("SCAN_RESULT") ?: ""
        Log.d("Codigo de barras:" , barcode.toString())
        scanResult = barcode

        scope.launch {
            val product = dao.getProductByBarcode(barcode)
            if (product != null) {
                productsScanned.add(product)
            }
        }
    }

    //Courrutine
    val context = LocalContext.current

    LaunchedEffect(true) {
        scope.launch {
            val productsdb = dao.getAllProducts()
            Log.i("Products", productsdb.toString())

            if (productsdb.isEmpty()) {
                // Voy a insertar los datos
                dao.insertAll(products)
            } else {
                Log.i("Products", "Ya existen productos en la base de datos")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("La tienda de Greys")
        Button(
            onClick = {
                //scoped Functions
                val options = ScanOptions().apply{
                    setPrompt("Escanea tu codigo de barras")
                    setBeepEnabled(true)
                }

                scanLauncher.launch(options.createScanIntent(context))
            }
        ) {
            Text("Escanear")
        }

        Text("El codigo de barra es: $scanResult")

        if (productsScanned.isNotEmpty()) {
            // Crear lista de productos
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(productsScanned){ product ->
                    ProductCard(product = product)
                }
            }
        }else{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Text("Sin productos")
            }
        }


    }
}

//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    device = Devices.PIXEL_7_PRO
//)
//@Composable
//fun HomescreenPreview(){
//    HomeScreen(innerPadding = PaddingValues(10.dp))
//}