package com.example.hciapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hciapp.components.LoginForm
import com.example.hciapp.ui.theme.Purple80

@Composable
fun LoginScreen(onLogin: (String, String) -> Unit) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
                //We have to see hoy to use Theme's colors. Not working.
                .background(color = Color(0xFFE1BEE7)))
        {
            Column( modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
            ) { Text("Balloon Wallet") }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(color = Color(0xFFFFFFFF))
                    .padding(16.dp)
            ) {
                LoginForm(onLogin = onLogin)
            }
        }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLogin = { _, _ -> })
}