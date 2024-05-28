package com.example.harmonyticket.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.harmonyticket.R

@Composable
fun DashboardScreen(navigationController: NavHostController){
    val dl = Brush.linearGradient(
        0.0f to Color(0xFF8450CC),
        0.5f to Color(0xFFAD91D3),
        1.0f to Color(0xFFFFFFFF),

        start = Offset.Zero,
        end = Offset.Infinite)

    Scaffold(
        topBar = {
            MyTopAppBar()
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Text(text = "Dashboard")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){

    val font = FontFamily(
        Font(R.font.playground)
    )
    
    TopAppBar(modifier = Modifier
        .padding(5.dp)
        .shadow(
            elevation = 8.dp,
            spotColor = Color.Black,
            shape = RoundedCornerShape(5.dp)
        ),
        title = { Text(text = "Harmony Ticket", fontFamily = font) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFAD91D3)
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Stadium, contentDescription = "" )
            }
        },
        actions = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    imageVector = Icons.Filled.ShoppingCart,
//                    contentDescription = "bag",
//                    tint = Color.Black)
//            }
            BadgedBox(
                badge = {
                Badge(contentColor = Color.White){
                    Text(text = "0")
                }
            },
                modifier = Modifier.padding(end=12.dp)
                ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "bag",
                    tint = Color.Black)
            }
        }
        
        
        
    )
    
}

@Composable
fun ImageLogo(){
    Image(
        painter = painterResource(id = R.drawable.logo512x512),
        contentDescription = "logo")

}