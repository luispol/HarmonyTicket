package com.example.harmonyticket.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.harmonyticket.navigation.Routes

@Composable
fun accountScreen(navigationController:NavHostController){
    Box(modifier = Modifier
        .fillMaxSize().background(Color.Gray),
        contentAlignment = Alignment.Center

    ){
        Button(onClick = { navigationController.navigate(Routes.Dashboard.route) }) {
            Text(text = "Account")
        }

    }

}