package com.example.labo6.data.repository

import com.example.labo6.data.api.KtorClient
import com.example.labo6.data.api.users.RestaurentsResponseDto
import com.example.labo6.data.api.users.toModel
import com.example.labo6.data.model.Restaurante
import io.ktor.client.call.body
import io.ktor.client.request.get

class RestauranteApiRepositorie : RestauranteRepository {

    override suspend fun getRestaurante(): Result<List<Restaurante>> {
        return try {
            val users = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<List<RestaurentsResponseDto>>()
                .map { it.toModel() }
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}