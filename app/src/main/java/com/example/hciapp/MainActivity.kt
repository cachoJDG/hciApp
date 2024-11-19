package com.example.hciapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hciapp.components.BalloonTopBar
import com.example.hciapp.screens.BallonApp
import com.example.hciapp.screens.HomeScreen
import com.example.hciapp.ui.theme.HciAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // hacer q ocupe el 100% de la pantalla nuestra app
        setContent {
            HciAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowTwoLabels(){
    Row {
        Text(text = "A")
        Text(text = "B")
    }

}

@Preview(showBackground = true)
@Composable
fun ShowTwoLabelsPreview() {
    HciAppTheme {
        ShowTwoLabels()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HciAppTheme {
        BallonApp()
    }
}