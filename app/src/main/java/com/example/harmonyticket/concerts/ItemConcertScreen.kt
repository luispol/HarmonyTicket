package com.example.harmonyticket.concerts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.harmonyticket.component.fontCaramel
import com.example.harmonyticket.component.fontComic
import com.example.harmonyticket.util.ConcertShoppingCart
import java.text.NumberFormat

@Composable
fun ItemConcertScreen(
    navigationController: NavHostController,
    itemConcertViewModel: ItemConcertsViewModel,
    totalItems: Int
){
    val concert by itemConcertViewModel.concert.collectAsState()
    val quantity by itemConcertViewModel.quantity.observeAsState(initial = 1)

    TemplateApp(navigationController = navigationController, totalItems){

        Column(
            Modifier
                .padding(it)
                .fillMaxSize()) {
            MyTopAppBarTicket()

            Column(
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 5.dp, end = 5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row {
                    Box(
                        modifier = Modifier
                            .size(150.dp)
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
                            text = "Artist: ${concert.nombre_cantante}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()
                        )

                        Text(
                            text = "Concert: ${concert.nombre_concierto}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )

                        Text(
                            text = "Concert: ${concert.lugar}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )

                        Text(
                            text = "Date: ${concert.fecha}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )
                        val price = NumberFormat.getCurrencyInstance().format(concert.precio.toDouble())
                        Text(

                            text = "Price: ${price}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )

                        Text(
                            text = "Limited tickets: ${concert.existencia}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )
                        
                    }
                }

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                    contentAlignment = Alignment.Center

                ){

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Button(onClick = {
                            itemConcertViewModel.saveShoppingCart(
                                ConcertShoppingCart(
                                    concert.id_concert,
                                    concert.nombre_concierto,
                                    concert.nombre_cantante,
                                    concert.fecha,
                                    concert.lugar,
                                    concert.precio,
                                    concert.existencia,
                                    concert.genero,
                                    concert.foto,
                                    quantity

                                )

//                            val id_concierto:String="",
//                            val nombre_concierto:String="",
//                            val nombre_cantante:String="",
//                            val fecha:String="",
//                            val lugar:String="",
//                            val precio:String="",
//                            val existencia:String="String",
//                            val genero:String="String",
//                            val foto:String="",
//                            val cantidad:Int=0
                            )
                        },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF1E162B),
                                contentColor = Color.White,


                                )
                        ) {
                            Text(text = "Add",
                                fontFamily = fontComic,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.size(5.dp))
                        
                        OutlinedButton(onClick = {
                            itemConcertViewModel.setQuantity(quantity-1)
                        }) {

                            Text(
                                text = "-",
                                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = fontCaramel
                                )
                            
                        }
                        Spacer(modifier = Modifier.size(5.dp))

                        OutlinedButton(onClick = {

                        }) {

                            Text(
                                text = "$quantity",
                                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = fontCaramel
                            )

                        }
                        Spacer(modifier = Modifier.size(5.dp))

                        OutlinedButton(onClick = {
                            itemConcertViewModel.setQuantity(quantity+1)
                        }) {

                            Text(
                                text = "+",
                                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = fontCaramel
                            )

                        }

                    }

                }
            }



            }
        }

    }





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarTicket(){

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
                    text = "Concert",
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
                    onClick = { /*TODO*/ },
                ) {
                    Icon(imageVector = Icons.Filled.Stadium, contentDescription = "", tint = Color.White)
                }
            }
        )
    }
}