package com.example.hciapp

import MovimientosScreen
import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.hciapp.ui.theme.HciAppTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.hciapp.components.general.BalloonTopBar


import com.example.hciapp.navigation.AppDestinations
import com.example.hciapp.screens.QrScreen
import com.example.hciapp.screens.config.ConfigScreen
import com.example.hciapp.screens.profile.ProfileScreen
import com.example.hciapp.screens.home.HomeScreen

@Composable
fun BalloonWalletApp() {
    // Set up the NavController for navigation
    val navController = rememberNavController()
    // Scaffold for the overall layout, including the top bar and bottom bar
        // NavHost to define the navigation flow
        NavHost(navController = navController, startDestination = "home_screen") {
            composable("home_screen") {
                HomeScreen(navController = navController)  // Home screen
            }
            composable("movimientos") {
                MovimientosScreen()  // Details screen
            }
        }
}

@Preview(device = "spec:width=411dp,height=891dp")
@Preview(device = "spec:width=800dp,height=1280dp,dpi=240")
@Composable
fun BalloonPreview() {
    BalloonWalletApp()
}


