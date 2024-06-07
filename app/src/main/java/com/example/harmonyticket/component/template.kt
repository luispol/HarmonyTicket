package com.example.harmonyticket.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun TemplateApp(navigationController:NavHostController, totalItems:Int, content:@Composable (PaddingValues)->Unit){

    Scaffold(
        topBar = { MyTopAppBar(totalItems, navigationController) },
        bottomBar = { MyButtonNavigation(navigationController) },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(dl)
                .padding(innerPadding)
        ) {

        }
        content(innerPadding)
    }
}
