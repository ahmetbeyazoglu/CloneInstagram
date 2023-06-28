package com.herpestes.cloneinstagram.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.herpestes.cloneinstagram.IgViewModel

@Composable
fun SinglePostScreen(navController: NavController, vm: IgViewModel, post: PostData){
    Text(text = "Single post screen ${post.postDescription}")
}