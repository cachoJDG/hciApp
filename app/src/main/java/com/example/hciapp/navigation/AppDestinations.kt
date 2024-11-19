package com.example.hciapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.hciapp.R



enum class AppDestinations(
    @StringRes val label : Int,
    val icon : ImageVector,
    @StringRes val contentDescription: Int
    )
{
    HOME(label = R.string.home, icon = Icons.Default.Home, contentDescription = R.string.home),
   // CARDS(label = R.string.cards, icon = ?????, contentDescription = R.string.cards),
}
