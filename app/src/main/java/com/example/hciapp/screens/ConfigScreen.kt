package com.example.hciapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hciapp.components.BalloonTopBar
import com.example.hciapp.components.UserProfileConfig

@Composable
fun ConfigScreen() {
    Scaffold(
        topBar = { BalloonTopBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            UserProfileConfig(
                name = "John",
                surname = "Doe",
                email = "john.doe@example.com",
                age = 30,
                alias = "johnd",
                language = "English",
                cvu = "1234567890",
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfigScreenPreview() {
    ConfigScreen()
}