package com.example.labo6.Screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Restaurante(){
    val viewModel: ScreenRestauranteViewModel = viewModel()
    val isLoading by viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel. loadRestaurante()
    }
}