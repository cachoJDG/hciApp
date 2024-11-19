package com.example.hciapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.hciapp.R



enum class AppDestinations(
    @StringRes val label : Int,
    @DrawableRes val icon : Int,
    @StringRes val contentDescription: Int
    )
{
    HOME(label = R.string.home, icon = R.drawable.home, contentDescription = R.string.home),
    CARDS(label = R.string.cards, icon = R.drawable.qr_code, contentDescription = R.string.cards),
   // CARDS(label = R.string.cards, icon = Icons.Default.Call, contentDescription = R.string.cards),
}
