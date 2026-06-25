package com.example.labo6.data.api.users

import com.example.labo6.data.model.Restaurante
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurentsResponseDto(
    @SerialName("idMeal") val id: String,
    @SerialName("strMeal") val name: String,
    @SerialName("strCategory") val category: String,
    @SerialName("strArea") val area: String,
    @SerialName("strMealThumb") val thumbnailUrl: String
)

fun RestaurentsResponseDto.toModel(): Restaurante{
    return Restaurante(
        id = id,
        name = name,
        category = category,
        area = area,
        thumbnailUrl = thumbnailUrl
    )
}