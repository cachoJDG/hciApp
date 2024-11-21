package com.example.hciapp.screens.logiRegister

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hciapp.R
import com.example.hciapp.components.LoginForm
import com.example.hciapp.ui.theme.HciAppTheme

@Composable
fun LoginScreen(onLogin: (String, String) -> Unit) {
HciAppTheme {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9503A7), // Purple color
                modifier = Modifier
                    .padding(vertical = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.balloon),
            contentDescription = "Background",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .offset(y = (-50).dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            LoginForm(onLogin = onLogin)
        }
    }
}
}
@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLogin = { _, _ -> })
}