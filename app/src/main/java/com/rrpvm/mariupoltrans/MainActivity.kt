package com.rrpvm.mariupoltrans

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rrpvm.feature.home.HomeScreen
import com.rrpvm.feature.home.HomeScreenRoute
import com.rrpvm.mariupoltrans.ui.theme.MariupolTransTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MariupolTransTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(navController)
                    }
                ) { contentPadding ->
                    Box(modifier = Modifier.padding(contentPadding)) {
                        AppScreenHolder(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun AppScreenHolder(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = HomeScreenRoute.HOME_SCREEN) {
        composable(HomeScreenRoute.HOME_SCREEN) { HomeScreen() }
        composable("friendslist") { FriendsList() }
    }
}


@Composable
fun BottomBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    BottomNavigation {
        BottomNavigationItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == HomeScreenRoute.HOME_SCREEN } == true,
            onClick = {
                navController.navigate(HomeScreenRoute.HOME_SCREEN)
            },
            icon = {
                Icon(Icons.Filled.Home, contentDescription = null)
            })
        BottomNavigationItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "friendslist" } == true,
            onClick = {
                navController.navigate("friendslist")
            },
            icon = {
                Icon(Icons.Filled.List, contentDescription = null)
            })
    }
}

@Composable
fun FriendsList() {
    Text("wow")
}
