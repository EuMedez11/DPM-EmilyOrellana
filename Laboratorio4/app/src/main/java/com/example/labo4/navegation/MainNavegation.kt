package com.example.labo4.navegation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.labo4.Screen.HomeScreen.HomeScreen
import com.example.labo4.Screen.Tarea.Greeting

@Composable
fun MainNavegation() {
    val backStack = rememberNavBackStack(Router.Home)
    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},

        entryProvider = entryProvider{

            entry<Router.Home>{
                HomeScreen (
                    navegationToGeeting = {backStack.add(Router.Greeting)}
                )
            }
            entry<Router.Greeting>{
                Greeting (
                    navegationBackHome  = {backStack.removeLastOrNull()}
                )
            }

        }

    )
}