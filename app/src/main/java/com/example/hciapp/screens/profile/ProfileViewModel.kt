package com.example.hciapp.screens.profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.hciapp.MyApplication
import com.example.hciapp.SessionManager
import com.example.hciapp.data.DataSourceException
import com.example.hciapp.data.model.User
import com.example.hciapp.data.repository.UserRepository
import com.example.hciapp.data.repository.WalletRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class ProfileViewModel(
    sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val walletRepository: WalletRepository
) : ViewModel()
{
    var uiState by mutableStateOf(ProfileUiState(isAuthenticated = sessionManager.loadAuthToken() != null))
        private set

    fun getCurrentUser() = runOnViewModelScope(
        { userRepository.getCurrentUser(uiState.currentUser == null) },
        { state, response -> state.copy(currentUser = response) }
    )

    fun getMagicUser()
    {
        uiState = uiState.copy(currentUser =
            User(
                id = 3, "Magic", "User",
                email = "magicUser@user.example.juamba.com",
                birthDate = TODO()
            )
        )
    }



    private fun <R> runOnViewModelScope(
        block: suspend () -> R,
        updateState: (ProfileUiState, R) -> ProfileUiState
    ): Job = viewModelScope.launch {
        uiState = uiState.copy(isFetching = true, error = null)
        runCatching {
            block()
        }.onSuccess { response ->
            uiState = updateState(uiState, response).copy(isFetching = false)
        }.onFailure { e ->
            uiState = uiState.copy(isFetching = false, error = handleError(e))
            Log.e(TAG, "Coroutine execution failed", e)
        }
    }

    private fun handleError(e: Throwable): Error {
        return if (e is DataSourceException) {
            Error(e.code.toString(), Throwable(e.message) as Throwable?)
        } else {
            Error(null, Throwable(e.message) as Throwable?)
        }
    }

    companion object {
        const val TAG = "UI Layer"

        fun provideFactory(
            application: MyApplication
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProfileViewModel(
                    application.sessionManager,
                    application.userRepository,
                    application.walletRepository) as T
            }
        }

    }
}
