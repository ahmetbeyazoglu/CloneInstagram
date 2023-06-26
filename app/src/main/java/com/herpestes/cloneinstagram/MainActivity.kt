package com.herpestes.cloneinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.herpestes.cloneinstagram.auth.SingupScreen
import com.herpestes.cloneinstagram.auth.loginScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.herpestes.cloneinstagram.main.NotificationMessage
import com.herpestes.cloneinstagram.ui.theme.CloneInstagramTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloneInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InstagramApp()
                }
            }
        }
    }
}

sealed class DestinationScreen(val route: String){
    object Signup: DestinationScreen("signup")
    object Login: DestinationScreen("Login")
}

@Composable
fun InstagramApp(){
    val vm = hiltViewModel<IgViewModel>()
    val navController = rememberNavController()
    
    NotificationMessage(vm = vm)


    NavHost(navController = navController, startDestination = DestinationScreen.Signup.route){
        composable(DestinationScreen.Signup.route){
            SingupScreen(navController= navController, vm =vm)
        }
        composable(DestinationScreen.Login.route){
            loginScreen(navController = navController, vm = vm )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CloneInstagramTheme {
        InstagramApp()
    }
}