package com.example.hciapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hciapp.R

@Composable
fun Balance() {
    var balance by remember { mutableStateOf(0) }
    var showBalance by remember { mutableStateOf(false) }

    ContentCard(title = stringResource(R.string.balance), description = "Your current balance") {
        Row() {
            Text(text = if (showBalance) balance.toString() else "****")
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = { showBalance = !showBalance },
                modifier = Modifier.size(16.dp)
            ) {
                val icon = if (showBalance) painterResource(id = R.drawable.closedeyes) else painterResource(id = R.drawable.eyecloseup)
                Icon(painter = icon, contentDescription = if (showBalance) "Hide balance" else "Show balance")
            }
        }
    }
}

@Preview
@Composable
fun BalancePreview() {
    Balance()
}