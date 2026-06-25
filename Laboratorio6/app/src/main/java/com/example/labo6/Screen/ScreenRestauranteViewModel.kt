package com.example.labo6.Screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labo6.data.model.Restaurante
import com.example.labo6.data.repository.RestauranteApiRepositorie
import com.example.labo6.data.repository.RestauranteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScreenRestauranteViewModel (
    private val restRepository: RestauranteRepository = RestauranteApiRepositorie() )
    : ViewModel(){

    private val _restaurant = MutableStateFlow<List<Restaurante>>(emptyList())
    val restaurant = _restaurant.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    fun loadRestaurante() {
        viewModelScope.launch {
            _loading.value = true
            restRepository.getRestaurante()
                .onSuccess { Restaurante ->
                    _restaurant.value = Restaurante
                    _errorMessage.value = null
                }
                .onFailure {
                    _errorMessage.value = "No se pudieron cargar las recetas"
                }
            _loading.value = false
        }
    }
}
