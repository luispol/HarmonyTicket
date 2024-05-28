package com.example.harmonyticket.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.harmonyticket.account.accountScreen
import com.example.harmonyticket.dashboard.DashboardScreen
import com.example.harmonyticket.tickets.myTicketScreen


@Composable
fun NavComponent(){
   val navigationController = rememberNavController()
   NavHost(navController = navigationController, startDestination = Routes.Dashboard.route) {
      composable(route=Routes.Dashboard.route) {
         DashboardScreen(navigationController)
      }


      composable(route=Routes.MyTickets.route) {
         myTicketScreen(navigationController)

      }

         composable(route=Routes.Account.route) { accountScreen(navigationController)
      }
   }
}