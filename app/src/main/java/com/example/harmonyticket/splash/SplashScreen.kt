package com.example.harmonyticket.splash

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.harmonyticket.DashBoardActivity
import com.example.harmonyticket.MainActivity
import com.example.harmonyticket.R
import com.example.harmonyticket.login.Brand
import com.example.harmonyticket.component.dl
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(context: Context){
    val dataStore = StoreToken(context = context)
    val token = dataStore.getToken.collectAsState(initial = "")
    LaunchedEffect(key1 = true) {
        delay(2000)
        if(token.value==""){
            context.startActivity(Intent(context,MainActivity::class.java))
        } else {
            context.startActivity(Intent(context, DashBoardActivity::class.java))
        }
        (context  as Activity).finish()
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(dl),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Image(
                painter = painterResource(id = R.drawable.newlogo),
                contentDescription = "",
                modifier = Modifier
                    .size(300.dp)
                    .align(alignment = Alignment.CenterHorizontally))

            Brand(Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                color = Color(0xFFAD91D3)
            )
        }
    }
}

