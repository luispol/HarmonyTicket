package com.example.harmonyticket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Stadium
import androidx.compose.material.icons.filled.StickyNote2
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.harmonyticket.R
import com.example.harmonyticket.navigation.Routes

@Composable
fun MyButtonNavigation(navigationController: NavHostController){
    BottomAppBar(
        modifier = Modifier
            .padding(5.dp)
            .shadow(
                elevation = 8.dp,
                spotColor = Color.Black,
                shape = RoundedCornerShape(5.dp)
            ),
        containerColor = Color(0xFFFFFFFF),
        actions = {
            IconButton(
                onClick = { navigationController.navigate(Routes.Dashboard.route) },
                modifier = Modifier.weight(1f)

            ) {
                Icon(
                    imageVector = Icons.Filled.Stadium,
                    contentDescription = "Home",
                    modifier = Modifier.size(50.dp))
            }

            IconButton(
                onClick = { navigationController.navigate(Routes.MyTickets.route) },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.StickyNote2,
                    contentDescription = "Tickets",
                    modifier = Modifier.size(50.dp))

            }

            IconButton(
                onClick = { navigationController.navigate(Routes.Account.route) },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Account",
                    modifier = Modifier.size(50.dp))
            }

        })
}