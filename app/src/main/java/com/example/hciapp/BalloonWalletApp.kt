package com.example.hciapp

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
import androidx.compose.ui.res.stringResource
import androidx.window.core.layout.WindowWidthSizeClass

import com.example.hciapp.navigation.AppDestinations
import com.example.hciapp.screens.HomeScreen

@Composable
fun BalloonWalletApp()
{
    HciAppTheme {
        val adaptiveInfo = currentWindowAdaptiveInfo()
        val customNavSuiteType = with(adaptiveInfo)
        {
            if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM) {
                NavigationSuiteType.NavigationRail
            }
            else {
                NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
            }

        }
        var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                AppDestinations.entries.forEach{
                    item(
                        icon = {
                            Icon(
                                it.icon,
                                contentDescription = stringResource(it.contentDescription)
                            )
                        },
                        label = { Text(stringResource(it.label)) },

                        selected = currentDestination == it,
                        onClick = { currentDestination = it }
                    )
                }
            },
            layoutType = NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        ){
            when(currentDestination)
            {
                AppDestinations.HOME -> HomeScreen()
            }

        }
    }
}
