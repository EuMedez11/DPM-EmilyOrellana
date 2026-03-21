package com.example.laboratorio1

import android.util.Log

class Calculadora(
    val marca: String,
    val aniosvida: Int,
    var precio: Double
){
    fun Calculadora (){
        Log.d("Labo1","Ejercicio de calculadora")
    }
    fun suma(a : Double, b : Double):Double{
        return a+b
    }

    fun resta(a : Double, b : Double):Double{
        return a-b
    }

    fun multiplicacion(a : Double, b : Double):Double{
        return a*b
    }

    fun division(a: Double, b: Double): Double {
        if (b == 0.0) {
            println("Error: no se puede dividir entre 0")
            return 0.0
        }
        return a / b
    }

    fun separacion(){
        Log.d("Labo1","----------------------------------------")
    }
}

