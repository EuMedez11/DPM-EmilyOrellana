package com.example.labo4.navegation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Router : NavKey {
    @Serializable
    data object Home : Router()

    @kotlinx.serialization.Serializable
    data object Greeting : Router()
}