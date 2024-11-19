package com.example.hciapp.components



import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hciapp.R

@Composable
fun BalloonNavigationBar(modifier: Modifier = Modifier)
{
    NavigationBar(
        containerColor = colorScheme.primary,
        contentColor = colorScheme.onPrimary,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = { Text(stringResource(R.string.home)) },

            selected = true,
            onClick = {  }

        )

    }
}

@Preview(showBackground = true)
@Composable
fun BalloonNavigationBarPreview()
{
    BalloonNavigationBar()
}