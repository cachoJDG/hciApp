package com.example.hciapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.hciapp.MyApplication
import com.example.hciapp.components.homeScreen.Balance
import com.example.hciapp.components.general.BalloonTopBar
import com.example.hciapp.ui.theme.HciAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hciapp.components.homeScreen.WrappedMovementsBox
import com.example.hciapp.data.model.Movement


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.provideFactory(LocalContext.current.applicationContext as MyApplication))
) {
    HciAppTheme {
        Scaffold(
            topBar = { BalloonTopBar(title = "Home", onBackClick = {}, arrowBack = false) },
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor =  MaterialTheme.colorScheme.background,

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
                WrappedMovementsBox( movements = listOf(
                    Movement("Compra", "Supermercado", "2023-10-01"),
                    Movement("Venta", "Mercado", "2023-10-02"),
                    Movement("Transferencia", "Banco", "2023-10-03"),
                    Movement("Compra", "Supermercado", "2023-10-01"),
                    Movement("Venta", "Mercado", "2023-10-02")
                ))
            }
        }
    }
}