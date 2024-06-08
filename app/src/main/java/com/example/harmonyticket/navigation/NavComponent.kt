package com.example.harmonyticket.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.harmonyticket.account.AccountViewModel
import com.example.harmonyticket.account.accountScreen
import com.example.harmonyticket.concerts.ConcertsViewModel
import com.example.harmonyticket.concerts.DashboardScreen
import com.example.harmonyticket.concerts.ItemConcertScreen
import com.example.harmonyticket.concerts.ItemConcertsViewModel
import com.example.harmonyticket.concerts.ShoppingCartScreen
import com.example.harmonyticket.concerts.ShoppingCartViewModel
import com.example.harmonyticket.tickets.MyTicketsViewModel
import com.example.harmonyticket.tickets.myTicketScreen


@Composable
fun NavComponent(){
   val navigationController = rememberNavController()
   val concertsViewModel = ConcertsViewModel(LocalContext.current)
   val itemConcertViewModel = ItemConcertsViewModel(LocalContext.current)
   val totalItems by concertsViewModel.totalItems.observeAsState(initial = 0)
   val shoppingCartViewModel = ShoppingCartViewModel(LocalContext.current)
   val myTicketsViewModel = MyTicketsViewModel(LocalContext.current)
   val accountViewModel = AccountViewModel(LocalContext.current)

   NavHost(navController = navigationController, startDestination = Routes.Dashboard.route) {
      composable(route=Routes.Dashboard.route) {
         concertsViewModel.getTotalItems()
         concertsViewModel.loadData()
         DashboardScreen(navigationController, concertsViewModel, totalItems)
      }


      composable(route=Routes.MyTickets.route) {
         myTicketsViewModel.loadData()
         myTicketScreen(navigationController, myTicketsViewModel,totalItems)

      }

         composable(route=Routes.Account.route) {
            accountViewModel.loadData()
            accountScreen(navigationController,totalItems, accountViewModel)
      }

      composable(route=Routes.ItemScreen.route) {arg->
         val id = arg.arguments?.getString("id")
         itemConcertViewModel.getOneConcert(id!!)
         ItemConcertScreen(navigationController, itemConcertViewModel,totalItems)
      }

      composable(route=Routes.ShoppingScreen.route) {arg->
         ShoppingCartScreen(navigationController, shoppingCartViewModel, totalItems)
      }
   }
}