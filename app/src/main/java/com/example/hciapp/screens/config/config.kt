package com.example.hciapp.screens.config

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.hciapp.components.general.BalloonNavigationBar
import com.example.hciapp.components.general.BalloonTopBar
import com.example.hciapp.ui.theme.HciAppTheme

@Composable
fun ConfigScreen() {
    var fontSize by remember { mutableStateOf(16.sp) }
    var notificationsEnabled by remember { mutableStateOf(true) }
    var isDarkaux = isSystemInDarkTheme()
    var isDarkTheme by remember { mutableStateOf(isDarkaux) }

    HciAppTheme(darkTheme = isDarkTheme) {
        Scaffold(
            topBar = { BalloonTopBar(title = "Settings", onBackClick = {}, arrowBack = true) },
            bottomBar = {
                BalloonNavigationBar()
            },
            containerColor = MaterialTheme.colorScheme.background,
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                // Theme Mode Toggle
                Text(text = "Dark Mode", style = MaterialTheme.typography.bodyLarge)
                Switch(
                    checked = isDarkTheme,
                    onCheckedChange = { isDarkTheme = it },
                    modifier = Modifier.padding(vertical = 8.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.secondary,
                        checkedTrackColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),
                        uncheckedThumbColor = MaterialTheme.colorScheme.onSurface,
                        uncheckedTrackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                )
                Text(
                    text = if (isDarkTheme) "Dark mode is enabled" else "Dark mode is disabled",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Font Size Slider
                Text(text = "Font Size", style = MaterialTheme.typography.bodyLarge)
                Slider(
                    value = fontSize.value,
                    onValueChange = { fontSize = it.sp },
                    valueRange = 12f..24f,
                    modifier = Modifier.padding(vertical = 8.dp),
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.24f)
                    )
                )
                Text(
                    text = "Selected font size: ${fontSize.value.toInt()}sp",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Notifications Toggle
                Text(text = "Notifications", style = MaterialTheme.typography.bodyLarge)
                Switch(
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it },
                    modifier = Modifier.padding(vertical = 8.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.secondary,
                        checkedTrackColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),
                        uncheckedThumbColor = MaterialTheme.colorScheme.onSurface,
                        uncheckedTrackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                )
                Text(
                    text = if (notificationsEnabled) "Notifications are enabled" else "Notifications are disabled",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfigScreenPreview() {
    ConfigScreen()
}