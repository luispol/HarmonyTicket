package com.example.harmonyticket.concerts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material.icons.filled.StickyNote2
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.harmonyticket.component.TemplateApp
import com.example.harmonyticket.component.fontComic
import com.example.harmonyticket.navigation.Routes
import java.text.NumberFormat

@Composable
fun ShoppingCartScreen(
    navigationController: NavHostController,
    shoppingCartViewModel: ShoppingCartViewModel,
    totalItems: Int
    ){
    val listConcertShoppingCart by shoppingCartViewModel.listConcertShoppingCart.observeAsState(initial = emptyList())
    TemplateApp(navigationController = navigationController, totalItems){

        Column(
            Modifier
                .padding(it)
                .fillMaxSize()) {
            MyTopAppBarShoping()

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(listConcertShoppingCart) { concert ->
                    Column(
                        modifier = Modifier
                            .padding(bottom = 10.dp, start = 5.dp, end = 5.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Column(Modifier.fillMaxSize()) {

                            Box(
                                modifier = Modifier
                                    .size(180.dp)
                                    .padding(5.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {

                                Image(
                                    painter = rememberAsyncImagePainter(model = concert.foto),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop

                                )
                            }

                            Column {
                                Text(
                                    text = "Concert: ${concert.nombre_concierto}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()

                                )

                                Text(
                                    text = "Artist: ${concert.nombre_cantante}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()
                                )

                                Text(
                                    text = "Place: ${concert.lugar}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()
                                )



                                Text(
                                    text = "Date: ${concert.fecha}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()

                                )
                                val price = NumberFormat.getCurrencyInstance()
                                    .format(concert.precio.toDouble())
                                Text(

                                    text = "Price: $price",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()

                                )

                                Text(

                                    text = "Tickets Available: ${concert.existencia}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()

                                )

                                Text(

                                    text = "Genre: ${concert.genero}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()

                                )

                                Text(

                                    text = "Quantity: ${concert.cantidad}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = fontComic,
                                    textAlign = TextAlign.Left,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            end = 5.dp,
                                            bottom = 5.dp,
                                            top = 5.dp
                                        )
                                        .fillMaxWidth()

                                )
                            }
                        }
                    }


                }

            }

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
                contentAlignment = Alignment.Center

            ){
                Button(onClick = {
                    shoppingCartViewModel.saveOrder()
                },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E162B),
                        contentColor = Color.White,


                        )
                ) {
                    Text(text = "Order Ticket(s)",
                        fontFamily = fontComic,
                        fontWeight = FontWeight.Bold
                    )
                }

            }


        }

        }
    }






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarShoping(){

    Box(
        modifier = Modifier
            .padding(5.dp)
            .border(BorderStroke(3.dp, Color(0xFFFFFFFF)), shape = RoundedCornerShape(5.dp))
    ) {
        TopAppBar(
            modifier = Modifier
                .shadow(
                    elevation = 1.dp,
                    spotColor = Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .clip(RoundedCornerShape(5.dp)),

            title = {
                Text(
                    text = "Shopping Cart",
                    fontSize = 24.sp,
                    fontFamily = fontComic,
                    color = Color.White
                )
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
            navigationIcon = {
                IconButton(
                    onClick = { 
                              
                    },
                ) {
                    Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "", tint = Color.White)
                }
            }
        )
    }
}


//val id_concierto:String="",
//val nombre_concierto:String="",
//val nombre_cantante:String="",
//val fecha:String="",
//val lugar:String="",
//val precio:String="",
//val existencia:String="",
//val genero:String="",
//val foto:String ="",
//val cantidad:Int=0