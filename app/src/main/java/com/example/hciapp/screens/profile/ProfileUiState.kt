package com.example.hciapp.screens.profile

import com.example.hciapp.data.model.User
import com.example.hciapp.data.model.WalletDetails

data class ProfileUiState(
    val isFetching: Boolean = false,
    val error: Error? = null,
    val currentUser: User? = null,
    val walletDetails: WalletDetails? = null,
    val isAuthenticated: Boolean = false,
)

val ProfileUiState.canGetCurrentUser: Boolean get() = isAuthenticated