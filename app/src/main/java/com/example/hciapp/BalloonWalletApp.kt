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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.window.core.layout.WindowWidthSizeClass


import com.example.hciapp.navigation.AppDestinations
import com.example.hciapp.screens.QrScreen
import com.example.hciapp.screens.home.HomeScreen

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
                NavigationSuiteType.NavigationBar
            }

        }
        var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
        NavigationSuiteScaffold(
            containerColor = Color.Blue,
            navigationSuiteItems = {
                AppDestinations.entries.forEach{
                    item(
                        icon = {
                            Icon(
                                painterResource( it.icon),
                                contentDescription = stringResource(it.contentDescription)
                            )
                        },
                        label = { Text(stringResource(it.label)) },

                        selected = currentDestination == it,
                        onClick = { currentDestination = it }
                    )
                }
            },
            contentColor = Color.Transparent,
            layoutType = NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        ){
            when(currentDestination)
            {
                AppDestinations.HOME -> HomeScreen()
                AppDestinations.CARDS -> QrScreen()
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


