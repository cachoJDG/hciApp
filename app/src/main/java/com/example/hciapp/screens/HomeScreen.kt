package com.example.hciapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hciapp.components.BalloonNavigationBar
import com.example.hciapp.components.BalloonTopBar
import com.example.hciapp.components.ContentCard
import com.example.hciapp.ui.theme.HciAppTheme


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HciAppTheme {
        Scaffold(
            topBar = { BalloonTopBar() },
        ) { padding ->

            Column(
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                ContentCard(
                    title = "Welcome to Balloon",
                ) {
                    Text("This is a simple app to demonstrate the use of Jetpack Compose")
                }
            }
        }
    }
}