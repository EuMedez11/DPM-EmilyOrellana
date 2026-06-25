package com.example.labo6.data.repository

import com.example.labo6.data.model.Restaurante

interface RestauranteRepository {
    suspend fun getRestaurante(): Result<List<Restaurante>>
}