package com.herpestes.cloneinstagram.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.herpestes.cloneinstagram.DestinationScreen
import com.herpestes.cloneinstagram.IgViewModel
import com.herpestes.cloneinstagram.main.navigateTo

@Composable
fun loginScreen(navController: NavController, vm: IgViewModel){
    Text(text = "New here? Go to signup -> ",
        color = Color.Blue,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navigateTo(navController, DestinationScreen.Signup)
            }
    )
}