package com.example.laboratorio3.Router

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
sealed class Router : NavKey {
    @Serializable
    data object Home : Router()

    @Serializable
    data object listaV : Router()

    @Serializable
    data object Senior : Router()
}