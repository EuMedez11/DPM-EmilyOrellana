package com.example.laboratorio3

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.laboratorio3.Router.Router
import com.example.laboratorio3.Screen.HomeScreen
import com.example.laboratorio3.Screen.LightSensor
import com.example.laboratorio3.Screen.ListView

@Composable
fun MainNavegation() {
    val backStack = rememberNavBackStack(Router.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },

        entryProvider = entryProvider {

            entry<Router.Home> {
                HomeScreen(
                    navegationToList = { backStack.add(Router.listaV) },
                    navegationToSensior = { backStack.add(Router.Senior) }
                )
            }
            entry<Router.listaV> {
                ListView(
                    navigationtoBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Router.Senior> {
                LightSensor(
                    navigationtoBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}
