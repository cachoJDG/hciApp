package com.example.hciapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hciapp.components.BalloonNavigationBar
import com.example.hciapp.components.BalloonTopBar
import com.example.hciapp.ui.theme.HciAppTheme

@Composable
fun BallonApp(){
    HciAppTheme {
        Scaffold(
            topBar = { BalloonTopBar() },
            bottomBar = { BalloonNavigationBar() }
        ) { padding->
            HomeScreen(Modifier.padding(padding))
        }
    }
}