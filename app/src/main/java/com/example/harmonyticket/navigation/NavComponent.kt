package com.example.harmonyticket.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.harmonyticket.account.accountScreen
import com.example.harmonyticket.concerts.ConcertsViewModel
import com.example.harmonyticket.concerts.DashboardScreen
import com.example.harmonyticket.concerts.ItemConcertScreen
import com.example.harmonyticket.concerts.ItemConcertViewMode
import com.example.harmonyticket.tickets.myTicketScreen


@Composable
fun NavComponent(){
   val navigationController = rememberNavController()
   val concertsViewModel = ConcertsViewModel(LocalContext.current)
   val itemConcertViewModel = ItemConcertViewMode(LocalContext.current)
   val totalItems by concertsViewModel.totalItems.observeAsState(initial = 25)

   NavHost(navController = navigationController, startDestination = Routes.Dashboard.route) {
      composable(route=Routes.Dashboard.route) {
         concertsViewModel.loadData()
         DashboardScreen(navigationController, concertsViewModel)
      }


      composable(route=Routes.MyTickets.route) {
         myTicketScreen(navigationController)

      }

         composable(route=Routes.Account.route) {
            accountScreen(navigationController)
      }

      composable(route=Routes.ItemScreen.route) {arg->
         val id = arg.arguments?.getString("id")
         itemConcertViewModel.getOneConcert(id!!)
         ItemConcertScreen(navigationController, itemConcertViewModel)
      }
   }
}