package com.example.hciapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hciapp.components.BalloonTopBar
import com.example.hciapp.ui.theme.HciAppTheme


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HciAppTheme {
        Column(modifier.verticalScroll(rememberScrollState()))
        {
            BalloonTopBar()
        }
    }
}