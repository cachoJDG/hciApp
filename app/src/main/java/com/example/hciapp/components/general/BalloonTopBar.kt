package com.example.hciapp.components.general

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.hciapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BalloonTopBar(title: String, onBackClick: () -> Unit, modifier: Modifier = Modifier, arrowBack: Boolean = true) {
    val navigationIcon: @Composable (() -> Unit)? = if (arrowBack) {
        {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = stringResource(id = R.string.cards)
                )
            }
        }
    } else {
        null
    }

    if (navigationIcon != null) {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = navigationIcon,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme.primary
            ),
            modifier = modifier
        )
    }
}