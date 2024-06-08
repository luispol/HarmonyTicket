package com.example.harmonyticket.account

import android.app.Activity
import android.content.Intent
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.harmonyticket.MainActivity
import com.example.harmonyticket.component.TemplateApp
import com.example.harmonyticket.component.fontComic
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun accountScreen(
    navigationController: NavHostController,
    totalItems: Int, accountViewModel: AccountViewModel) {

    val dataStore = StoreToken(context = LocalContext.current)
    val context = LocalContext.current
    val profile by accountViewModel.profile.collectAsState()


    TemplateApp(navigationController = navigationController, totalItems) {
        Column(Modifier.padding(it)) {
            MyTopAppBarAccount()
            Divider(
                modifier = Modifier
                    .padding(6.dp)
                    .height(2.dp),
                color = Color(0xFFD6D6D6)
            )

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
                            painter = rememberAsyncImagePainter(model = "${profile.foto}"),
                            contentDescription = "",
                            modifier = Modifier.size(150.dp),
                            contentScale = ContentScale.Crop

                        )
                    }


                    Column {
                        Text(
                            text = "${profile.username}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontComic,
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
                                .fillMaxWidth()
                        )

                        Text(
                            text = "${profile.nombres}" + " " + "${profile.apellidos}",
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

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Button(
                        onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                dataStore.saveToken("")
                                context.startActivity(Intent(context, MainActivity::class.java))
                                (context as Activity).finish()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1E162B),
                            contentColor = Color.White,


                            )
                    ) {
                        Text(
                            text = "Log Out",
                            fontFamily = fontComic,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

//            Button(onClick = {
//                CoroutineScope(Dispatchers.IO).launch {
//                    dataStore.saveToken("")
//                    context.startActivity(Intent(context, MainActivity::class.java))
//                    (context as Activity).finish()
//                }
//            }) {
//                Text(text = "Log Out")
//            }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarAccount(){

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
                    text = "Profile",
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
                    onClick = {  },
                ) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "", tint = Color.White)
                }
            }
        )
    }
}