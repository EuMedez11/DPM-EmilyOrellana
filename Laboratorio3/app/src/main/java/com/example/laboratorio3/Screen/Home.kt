package com.example.laboratorio3.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(navegationToList : ()-> Unit, navegationToSensior :()-> Unit){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {navegationToList()}){
            Text("Ver lista")
        }
        Button(onClick = {navegationToSensior()}){
            Text("Informacion del sensor")
        }

    }

}