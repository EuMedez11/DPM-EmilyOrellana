package com.example.laboratorio1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio1.ui.theme.Laboratorio1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Ejercicio de crear Computadora
        val programas = listOf("Notion 2026", "Facebook 2024", "Spotify 2026")
        val compu = Computadora(16, 256, "Windows", programas)

        compu.encenderComputadora()
        Log.d("Labo1", "Computadora encendida")
        Log.d("Labo1", "RAM: ${compu.ram}")
        Log.d("Labo1", "Almacenamiento: ${compu.almacenamiento}")
        Log.d("Labo1", "Sstema Operativo: ${compu.sistemaOperativo}")
        Log.d("Labo1", "Todos: ${compu.obtenerTodosProgramas()}")
        Log.d("Labo1", "Solo 2026: ${compu.obtenerProgramas()}")

        compu.actualizar(32,512,"Linux")
        Log.d("Labo1", "Computadora actualizada")
        Log.d("Labo1", "RAM: ${compu.ram}")
        Log.d("Labo1", "Almacenamiento: ${compu.almacenamiento}")
        Log.d("Labo1", "Sstema Operativo: ${compu.sistemaOperativo}")
        Log.d("Labo1", "Todos: ${compu.obtenerTodosProgramas()}")
        Log.d("Labo1", "Solo 2026: ${compu.obtenerProgramas()}")
        compu.apagarComputadora()
        Log.d("Labo1", "Computadora apagada")


        //Ejercicio de la Calculadora
        val calc = Calculadora("Casio", 5, 25.0)
        calc.separacion()
        calc.Calculadora()
        Log.d("Labo1", "Calculadora marca: ${calc.marca}")
        Log.d("Labo1", "Calculadora Precio: ${calc.precio}")
        Log.d("Labo1", "Suma: ${calc.suma(17.0, 5.0)}")
        Log.d("Labo1", "Resta: ${calc.resta(17.0, 5.0)}")
        Log.d("Labo1", "Multiplicación: ${calc.multiplicacion(21.0, 6.5)}")
        Log.d("Labo1", "División: ${calc.division(10.0, 5.0)}")
        Log.d("Labo1", "División entre 0: ${calc.division(10.0, 0.0)}")
        calc.separacion()

        // Ejercicio de Pasar lista
        val Ciclo01 = listOf(
            Estudiante("Emily Orellana", "00147124", "Programación de Dispositivos Móviles"),
            Estudiante("Gisela Rivas", "0000324", "Programación de Dispositivos Móviles"),
            Estudiante("Daniel Ayala", "0002824", "Programación de Dispositivos Móviles"),

            Estudiante("Carlos Riveras", "0000823", "Análisis numérico"),
            Estudiante("María Escobar", "0057122", "Análisis numérico"),
            Estudiante("Pedro Batres", "0008722", "Análisis numérico"),
            Estudiante("Lucía Melendez", "0072523", "Análisis numérico")
        )

        val moviles = Ciclo01.filter {
            it.asignatura == "Programación de Dispositivos Móviles"
        }

        Log.d("Labo1", "Estudiantes de Dispositivos Móviles:")

        for (est in moviles) {
            Log.d("Labo1", "Nombre: ${est.nombre}, Carnet: ${est.carnet}")
        }
        enableEdgeToEdge()
        setContent {
            Laboratorio1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Emily",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio1Theme {
        Greeting("Android")
    }
}