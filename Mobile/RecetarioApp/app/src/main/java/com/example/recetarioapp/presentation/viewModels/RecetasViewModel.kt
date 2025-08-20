package com.example.recetarioapp.presentation.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recetarioapp.presentation.models.Categoria
import com.example.recetarioapp.presentation.models.Receta
import com.example.recetarioapp.presentation.models.Usuario
import com.example.recetarioapp.services.ApiService
import com.example.recetarioapp.services.FavoritoUpdateRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecetaViewModel @Inject constructor(
    private val apiService: ApiService

) : ViewModel() {

    private val _flujoRecetasInterno  = MutableSharedFlow<List<Receta>>()
    val recetasFlow = _flujoRecetasInterno .asSharedFlow()

    private val _flujoCategoriasInterno  = MutableSharedFlow<List<Categoria>>()
    val categoriasFlow = _flujoCategoriasInterno .asSharedFlow()

    private val _flujoUsuariosInterno  = MutableSharedFlow<List<Usuario>>()
    val usuariosFlow = _flujoUsuariosInterno .asSharedFlow()

    private val _flujoErroresInterno  = MutableSharedFlow<String>()
    val errorFlow = _flujoErroresInterno .asSharedFlow()

    init {
        obtenerRecetas()
        obtenerCategorias()
        obtenerUsuarios()
    }

    fun obtenerRecetas() {
        viewModelScope.launch {
            try {
                val recetas = apiService.getRecetas()
                _flujoRecetasInterno.emit(recetas)
            } catch (e: Exception) {
                Log.e("RecetaViewModel", "Error cargando recetas", e)
                _flujoErroresInterno.emit("Error cargando recetas")
            }
        }
    }

    fun obtenerCategorias() {
        viewModelScope.launch {
            try {
                val cats = apiService.getCategorias()
                _flujoCategoriasInterno.emit(cats)
            } catch (e: Exception) {
                _flujoErroresInterno.emit("Error cargando categorías")
            }
        }
    }

    fun obtenerUsuarios() {
        viewModelScope.launch {
            try {
                val usuarios = apiService.getUsuarios()
                _flujoUsuariosInterno.emit(usuarios)
            } catch (e: Exception) {
                _flujoErroresInterno.emit("Error cargando usuarios")
            }
        }
    }

    fun agregarReceta(receta: Receta) {
        viewModelScope.launch {
            try {
                apiService.postReceta(receta)
                obtenerRecetas()
            } catch (e: Exception) {
                _flujoErroresInterno.emit("Error al agregar receta: ${e.message}")
            }
        }
    }

    fun actualizarFavorito(id: String, nuevoValor: Boolean) {
        viewModelScope.launch {
            try {
                val request = FavoritoUpdateRequest(favorite = nuevoValor)
                apiService.actualizarRecetaParcial(id, request)
                obtenerRecetas()
            } catch (e: Exception) {
                _flujoErroresInterno.emit("Error al actualizar favorito")
            }
        }
    }


}


