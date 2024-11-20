package com.example.hciapp.screens.config


import com.example.hciapp.data.model.User
import com.example.hciapp.data.model.WalletDetails


data class ConfigUiState(
    val isFetching: Boolean = false,
    val error: Error? = null,
    val currentUser: User? = null,
    val walletDetails: WalletDetails? = null,
    val isAuthenticated: Boolean = false,
)

val ConfigUiState.canGetCurrentUser: Boolean get() = isAuthenticated