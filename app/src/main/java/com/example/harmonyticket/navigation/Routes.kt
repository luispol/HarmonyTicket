package com.example.harmonyticket.navigation

sealed class Routes(val route:String) {
    object Dashboard:Routes("dashboard")
    object MyTickets:Routes("mytickets")
    object Account:Routes("account")
    object ItemScreen:Routes("itemconcert/{id}"){
        fun createRoute(id:String) = "itemconcert/$id"
    }

    object ShoppingScreen:Routes("shoppingcart")

}