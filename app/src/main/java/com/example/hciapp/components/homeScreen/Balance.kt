package com.example.hciapp.components.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hciapp.R
import com.example.hciapp.components.general.ButtonTile

@Composable
fun Balance(navController: NavController) {
    var balance by remember { mutableStateOf(0) }
    var showBalance by remember { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    ButtonTile(
                        onClick = { balance += 1 },
                        text = R.string.increase_balance,
                        icon = R.drawable.dinero
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                   ButtonTile(
                        onClick = { balance -= 1 },
                        text = R.string.decrease_balance,
                        icon = R.drawable.pago
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ButtonTile(
                        onClick = { balance = 0 },
                        text = R.string.cards,
                        icon = R.drawable.baseline_credit_card_24
                    )
                }
            }
            Column(modifier = Modifier.align(Alignment.TopEnd).padding(16.dp)) {
                Text(
                    text= "See my movements",
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable
                    { navController.navigate("movimientos")
                    })
            }
        }
    }
}
