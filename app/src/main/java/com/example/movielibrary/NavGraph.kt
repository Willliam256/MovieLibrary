package com.example.movielibrary

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movielibrary.ui.library.MovieLibraryScreen
import com.example.movielibrary.ui.library.SplashScreen

object Destinations {
    const val LIBRARY_ROUTE = "library"
    const val SPLASH_ROUTE = "splash"
}

@Composable
fun NavigationGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.SPLASH_ROUTE
    ){
        composable(Destinations.SPLASH_ROUTE){
            SplashScreen(
                navigateToLibrary = {
                    navController.navigate(Destinations.LIBRARY_ROUTE){
                        popUpTo(Destinations.SPLASH_ROUTE){inclusive = true}
                    }
                }
            )
        }
        composable(Destinations.LIBRARY_ROUTE){
            MovieLibraryScreen()
        }
    }
}