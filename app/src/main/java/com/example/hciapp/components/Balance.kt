package com.example.hciapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hciapp.R

@Composable
fun Balance() {
    var balance by remember { mutableStateOf(0) }
    var showBalance by remember { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = if (showBalance) "$$balance" else "****")
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = { showBalance = !showBalance },
                        modifier = Modifier.size(24.dp)
                    ) {
                        val icon = if (showBalance) painterResource(id = R.drawable.closedeyes) else painterResource(id = R.drawable.eyecloseup)
                        Icon(painter = icon, contentDescription = if (showBalance) "Hide balance" else "Show balance")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = { /* Action to increase balance */ },
                        modifier = Modifier
                            .size(48.dp) // Adjust the size for the button's diameter
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary) // Set the background color
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(id = R.drawable.dinero),
                            contentDescription = "Increase balance",
                             // Set the icon color
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color(0xFF9503A7), shape = CircleShape)
                    ) {
                        IconButton(
                            onClick = { balance -= 1 },
                            modifier = Modifier.size(24.dp).align(Alignment.Center)
                        ) {
                            val icon = painterResource(id = R.drawable.pago)
                            Icon(painter = icon, contentDescription = "Decrease balance")
                        }
                    }
                }
            }
            Column(modifier = Modifier.align(Alignment.TopEnd).padding(16.dp)) {
                Text(text= "See my movements", textDecoration = TextDecoration.Underline, color = Color(0xFF9503A7))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BalancePreview() {
    Balance()
}