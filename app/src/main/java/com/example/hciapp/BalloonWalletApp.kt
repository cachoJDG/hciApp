package com.example.hciapp

import MovimientosScreen
import androidx.compose.material3.Icon
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


import com.example.hciapp.navigation.AppDestinations
import com.example.hciapp.screens.QrScreen
import com.example.hciapp.screens.profile.ProfileScreen
import com.example.hciapp.screens.home.HomeScreen

@Composable
fun BalloonWalletApp() {
    HciAppTheme {
        val adaptiveInfo = currentWindowAdaptiveInfo()
        val navController = rememberNavController()

        // Set the navigation type based on window size
        val customNavSuiteType = with(adaptiveInfo) {
            if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM) {
                NavigationSuiteType.NavigationRail
            } else {
                NavigationSuiteType.NavigationBar
            }
        }

        var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

        // Wrap the NavigationSuiteScaffold
        NavigationSuiteScaffold(
            containerColor = Color.Blue,
            navigationSuiteItems = {
                // Set up items in the navigation bar
                AppDestinations.entries.forEach {
                    item(
                        icon = {
                            Icon(
                                painterResource(it.icon),
                                contentDescription = stringResource(it.contentDescription)
                            )
                        },
                        label = { Text(stringResource(it.label)) },
                        selected = currentDestination == it,
                        onClick = {
                            // Update current destination and navigate
                            currentDestination = it
                            // Optionally, navigate to the respective screen in NavHost
                            when (it) {
                                AppDestinations.HOME -> navController.navigate("home_screen")
                                AppDestinations.CARDS -> navController.navigate("qr_screen")
                                AppDestinations.PROFILE -> navController.navigate("profile_screen")
                                AppDestinations.SETTINGS -> navController.navigate("settings_screen")
                            }
                        }
                    )
                }
            },
            contentColor = Color.Transparent,
            layoutType = NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        ) {
            // Content area where screens are displayed based on current destination
            when (currentDestination) {
                AppDestinations.HOME -> HomeScreen(navController = navController)
                AppDestinations.CARDS -> QrScreen()
                AppDestinations.PROFILE -> ProfileScreen()
                AppDestinations.SETTINGS -> Text("Settings")
            }
        }

        // Set up NavHost for handling specific navigation in the app (for screen transitions)
        NavHost(navController = navController, startDestination = "home_screen") {
            composable("home_screen") {
                HomeScreen(navController = navController)
            }
            composable("details_screen") {
                MovimientosScreen()
            }
            composable("qr_screen") {
                QrScreen() // Add the QR screen
            }
            composable("profile_screen") {
                ProfileScreen() // Profile screen
            }
            composable("settings_screen") {
                Text("Settings") // You can replace this with the actual settings screen
            }
        }
    }
}

@Preview(device = "spec:width=411dp,height=891dp")
@Preview(device = "spec:width=800dp,height=1280dp,dpi=240")
@Composable
fun BalloonPreview() {
    BalloonWalletApp()
}


