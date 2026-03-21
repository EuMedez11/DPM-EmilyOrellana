package com.example.laboratorio1

import android.util.Log

class Computadora (
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String,
    var programasInstalados: List<String>
) {

    fun encenderComputadora(){
        Log.d("Labo1","Encendida")
    }

    fun apagarComputadora(){
        Log.d("Labo1","Apagada")
    }

    fun actualizar(nuevaRam: Int, nuevoAlma: Int, nuevoSO: String) {
        ram = nuevaRam
        almacenamiento = nuevoAlma
        sistemaOperativo = nuevoSO
    }

    fun obtenerTodosProgramas(): List<String>{
        return programasInstalados
    }
    fun obtenerProgramas(): List<String>{
        return programasInstalados.filter { it.contains("2026") }
    }
}