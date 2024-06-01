package com.example.harmonyticket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.harmonyticket.R
import com.example.harmonyticket.ui.theme.dl

@Composable
fun TemplateApp(navigationController:NavHostController, content:@Composable (PaddingValues)->Unit){

    Scaffold(
        topBar = { MyTopAppBar() },
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
