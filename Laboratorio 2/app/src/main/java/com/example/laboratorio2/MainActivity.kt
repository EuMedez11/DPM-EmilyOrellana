package com.example.laboratorio2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio2.ui.theme.Laboratorio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreeringAplicacion()
                    }
                }
            }
        }
    }


@Preview(showBackground = true)

@Composable
fun GreeringAplicacion() {
    val lista = remember { mutableStateListOf<String>() }
    val nombre: MutableState<String> = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            value = nombre.value,
            onValueChange = {
                nombre.value = it
            },
        )
        val pulsado: MutableState<Int> = remember {
            mutableIntStateOf(0)
        }
        Button(
            onClick = {
                lista.add(nombre.value)
                nombre.value = ""
            }
        ) {
            Text(text = "Guardar")
        }
        Row() {
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Listado de nombre y posicion en la lista",
                    modifier = Modifier.width(150.dp)
                )
                val pulsado: MutableState<Int> = remember {
                    mutableIntStateOf(0)
                }
            }
            Button(
                onClick = {
                    lista.clear()
                }
            ) {
                Text(text = "Limpiar")
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(300.dp).border(
                width = 2.dp,
                color = Color.Blue,
                shape = RoundedCornerShape(16.dp)
            ),
        ) {
            LazyColumn {
                itemsIndexed(lista) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item)
                        Text(text = (index + 1).toString())

                    }
                }
            }
        }
    }

}









