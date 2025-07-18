//package com.example.newsapplication.ui.components
//
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.currentBackStackEntryAsState
//import com.example.newsapplication.data.models.BottomNavItem
//import com.example.newsapplication.ui.view.CartScreen
//import com.example.newsapplication.ui.view.home.HomePage
//
//@Composable
//fun BottomNavBar(navController: NavController) {
//    val items = listOf(
//        BottomNavItem.Home,
//        BottomNavItem.Cart,
//        BottomNavItem.Settings
//    )
//
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//    NavigationBar {
//        items.forEach { item ->
//            NavigationBarItem(
//                selected = currentRoute== item.route,
//                onClick = {
//                    if (currentRoute != item.route) {
//                        navController.navigate(item.route) {
//                            popUpTo(navController.graph.startDestinationId) {
//                                saveState = true
//                            }
//                            launchSingleTop = true
//                            restoreState = true
//                        }
//                    }
//                },
//                icon = {Icon(item.icon, contentDescription = item.label)},
//                label = { Text(item.label) }
//            )
//        }
//    }
//}
//
//@Composable
//fun MainNavGraph(navController: NavHostController) {
//    NavHost(
//        navController, startDestination = BottomNavItem.Home.route,
//    ) {
//        composable(BottomNavItem.Home.route){ HomePage(navController) }
//        composable(BottomNavItem.Home.route) { CartScreen(navController = navController) }
//        composable(BottomNavItem.Home.route) { HomePage(navController) }
//    }
//}