package com.example.hciapp.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.hciapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BalloonTopBar(modifier: Modifier = Modifier)
{
    TopAppBar(
        title = { Text(text = stringResource(R.string.HeaderTitle)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorScheme.primary
        ),
        modifier = modifier
    )
}