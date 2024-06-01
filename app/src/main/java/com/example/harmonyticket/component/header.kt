package com.example.harmonyticket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.harmonyticket.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){

    val font = FontFamily(
        Font(R.font.playground)
    )

    TopAppBar(
        modifier = Modifier
            .padding(5.dp)
            .shadow(
                elevation = 8.dp,
                spotColor = Color.Black,
                shape = RoundedCornerShape(5.dp)
            ),
        title = { Text(text = "Harmony Ticket",
            fontSize = 26.sp,
            fontFamily = font,
            color = Color.Black) },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                ImageLogo()
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
                    modifier = Modifier.size(30.dp),
                    contentDescription = "bag",
                    tint = Color.Black)
            }
        }
    )
}

@Composable
fun ImageLogo(){
    Image(
        painter = painterResource(id = R.drawable.newlogo),
        contentDescription = "logo")

}