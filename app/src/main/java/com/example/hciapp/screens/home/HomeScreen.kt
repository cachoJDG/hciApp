package com.example.hciapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.hciapp.MyApplication
import com.example.hciapp.components.Balance
import com.example.hciapp.components.BalloonTopBar
import com.example.hciapp.components.ContentCard
import com.example.hciapp.components.LoginForm
import com.example.hciapp.ui.theme.HciAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.provideFactory(LocalContext.current.applicationContext as MyApplication))
) {
    HciAppTheme {
        Scaffold(
            topBar = { BalloonTopBar() },
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor =  MaterialTheme.colorScheme.primary,

        ) { padding ->


            Column(
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
//                Button(
//                    onClick = {
//                        viewModel.login("DOLOR", "123456789")
//                        }
//                ) {
//                        Text("Login")
//                    }



                Balance()

                ContentCard(
                    title = "Welcome to Balloon",
                ) {
                    LoginForm { email, password ->
                        // Handle login
                    }
                }


            }
        }
    }
}