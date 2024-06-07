package com.example.harmonyticket.tickets

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StickyNote2
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.harmonyticket.R
import com.example.harmonyticket.component.TemplateApp
import com.example.harmonyticket.component.fontComic




fun simulateDownload(context: Context) {
    Toast.makeText(context, "downloading Tickets...", Toast.LENGTH_LONG).show()
}
@Composable
fun myTicketScreen(navigationController: NavHostController, myTicketsViewModel: MyTicketsViewModel,totalItems: Int){
    val myTickets by myTicketsViewModel.myTickets.collectAsState()
    val myReport by myTicketsViewModel.report.collectAsState()
    val showReportUrl = remember { mutableStateOf(false) }
    val context = LocalContext.current
    TemplateApp(navigationController = navigationController,totalItems){
        Column(Modifier.padding(it)) {


            MyTopAppBarMyTickets()
            Divider(
                modifier = Modifier
                    .padding(6.dp)
                    .height(2.dp),
                color = Color(0xFFD6D6D6)
            )
            LazyColumn(modifier = Modifier.padding(5.dp)) {
                items(myTickets) { myTickets ->
                    Column(
                        modifier = Modifier
                            .padding(bottom = 10.dp, start = 5.dp, end = 5.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Column {
                            Text(
                                text = "Artist: ${myTickets.nombre_concierto}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = fontComic,
                                textAlign = TextAlign.Left,
                                modifier = Modifier
                                    .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                    .fillMaxWidth()
                            )

                            Text(
                                text = "Concert: ${myTickets.nombre_cantante}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = fontComic,
                                textAlign = TextAlign.Left,
                                modifier = Modifier
                                    .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                    .fillMaxWidth()

                            )

                            Text(
                                text = "Genre: ${myTickets.fecha}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = fontComic,
                                textAlign = TextAlign.Left,
                                modifier = Modifier
                                    .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                    .fillMaxWidth()

                            )

                            Text(
                                text = "Concert: ${myTickets.lugar}",
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
                }

            }
            Button(onClick = { showReportUrl.value = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB39DDB))
                ) {
                Text(text = "Download My Tickets", fontWeight = FontWeight.Bold, color = Color.White)
            }
            if (showReportUrl.value){
                /*Text(text = "${myReport.file}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    modifier = Modifier.padding(10.dp)
                    )*/
                val annotatedString = buildAnnotatedString {
                    val str = "${myReport.file}"
                    append(str)
                    addStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        ), start = 0, end = str.length
                    )
                }
                ClickableText(
                    text = annotatedString,
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        simulateDownload(context)
                    }
                )


            }
        }
        


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarMyTickets(){

    val font = FontFamily(
        Font(R.font.heycomic)
    )
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
                    text = "My Tickets",
                    fontSize = 24.sp,
                    fontFamily = font,
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
                    Icon(imageVector = Icons.Filled.StickyNote2, contentDescription = "", tint = Color.White)
                }
            }
        )
    }
}
