package com.example.harmonyticket.concerts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
fun DashboardScreen(
    navigationController: NavHostController,
    concertsViewModel: ConcertsViewModel,
    totalItems: Int
){
    TemplateApp(navigationController = navigationController, totalItems){

        Column(
            Modifier
                .padding(it)
                .fillMaxSize()) {


            MyTopAppBarConcerts()
            Divider(
                modifier = Modifier
                    .padding(6.dp)
                    .height(2.dp),
                color = Color(0xFFD6D6D6)
            )
            ListConcerts(concertsViewModel,navigationController)
        }
    }
}

@Composable
fun ListConcerts(concertsViewModel: ConcertsViewModel, navigationController: NavHostController){
    val concerts by concertsViewModel.concerts.collectAsState()

    LazyColumn(modifier = Modifier.padding(5.dp)) {
        items(concerts){concerts->
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
                            .size(180.dp)
                            .padding(5.dp)
                            .clip(RoundedCornerShape(5.dp))
                    ) {

                        Image(
                            painter = rememberAsyncImagePainter(model = concerts.foto),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop

                        )
                    }


                    Column {
                        Text(
                            text = "Artist: ${concerts.nombre_cantante}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()
                        )

                        Text(
                            text = "Concert: ${concerts.nombre_concierto}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )

                        Text(
                            text = "Genre: ${concerts.genero}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )

                        Text(
                            text = "Concert: ${concerts.lugar}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )


                        Text(
                            text = "Date: ${concerts.fecha}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()

                        )
//                        val price = NumberFormat.getCurrencyInstance().format(concerts.precio.toDouble())
//                        Text(
//
//                            text = "Price: ${price}",
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.SemiBold,
//                            fontFamily = fontComic,
//                            textAlign = TextAlign.Left,
//                            modifier = Modifier
//                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
//                                .fillMaxWidth()
//
//                        )

//                        Text(
//                            text = "Limited tickets: ${concerts.existencia}",
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.SemiBold,
//                            fontFamily = fontComic,
//                            textAlign = TextAlign.Left,
//                            modifier = Modifier
//                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
//                                .fillMaxWidth()
//
//                        )
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
                            navigationController.navigate(Routes.ItemScreen.createRoute(concerts.id_concert))
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
                            Text(text = "Buy",
                                fontFamily = fontComic,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.size(5.dp))

//                        Button(onClick = {
//                            ShoppingCartViewModel
//                        },
//                            modifier = Modifier
//                                .weight(1f)
//                                .fillMaxWidth(),
//                            shape = RoundedCornerShape(5.dp),
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = Color(0xFF1E162B),
//                                contentColor = Color.White,
//
//
//                                )
//                        ) {
//                            Text(text = "clean",
//                                fontFamily = fontComic,
//                                fontWeight = FontWeight.Bold
//                            )
//                        }
                    }

                }
            }

        }
    }
}

//@SerializedName("id_concierto") val id_producto:String="",
//@SerializedName("nombre_concierto") val nombre_producto:String="",
//@SerializedName("nombre_cantante") val nombre_cantante:String="",
//@SerializedName("fecha") val fecha:String="",
//@SerializedName("precio") val precio:String="",
//@SerializedName("existencia") val existencia:String="",
//@SerializedName("id_genero") val id_genero:String="",
//@SerializedName("foto") val foto:String=""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarConcerts(){

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
                    text = "Concerts",
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



