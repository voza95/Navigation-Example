package com.example.navigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable(route = "registration") {
            RegistrationScreen {
                navController.navigate("main/$it")
            }
        }
        composable(route = "login") {
            LoginScreen()
        }
        composable(route = "main/{email}", arguments = listOf(
            navArgument("email") {
                type = NavType.StringType
            }
        )) {
            val email = it.arguments!!.getString("email")
            MainScreen(email)
        }
    }
}

@Composable
fun RegistrationScreen(onClick: (email: String)->Unit) {
    Text(
        text = "Registration",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.clickable {
            onClick("xyz@abc.co.in")
        }
    )
}

@Composable
fun LoginScreen() {
    Text(text = "Login", style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun MainScreen(email: String?) {
    Text(text = "Main Screen - $email", style = MaterialTheme.typography.bodyMedium)
}