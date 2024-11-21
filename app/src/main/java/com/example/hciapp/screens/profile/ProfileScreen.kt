package com.example.hciapp.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hciapp.MyApplication
import com.example.hciapp.components.general.BalloonTopBar
import com.example.hciapp.components.profile.UserProfileConfig
import java.util.Date

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel(factory = ProfileViewModel.provideFactory(LocalContext.current.applicationContext as MyApplication))
) {
    val uiState = viewModel.uiState
    Scaffold(
        topBar = { BalloonTopBar(title = "Config", onBackClick = {}) },
        containerColor = MaterialTheme.colorScheme.background,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            UserProfileConfig(
                name = uiState.currentUser?.firstName ?: "John",
                surname = uiState.currentUser?.lastName ?: "Doe",
                email = uiState.currentUser?.email ?: "jhon.doe@example.com",
                birthDate = uiState.currentUser?.birthDate ?: Date(),
                alias = "johnd",
                language = "English",
                cvu = "1234567890",
                )
            Button(onClick = {
                viewModel.getCurrentUser()
            }) {
                Text("Magic Button")
            }
        }

    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}