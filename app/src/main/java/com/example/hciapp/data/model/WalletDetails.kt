package com.example.hciapp.data.model

import com.example.hciapp.data.network.model.NetworkCard
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WalletDetails (
    var balance: Int,
    var invested: Int,
    var cbu : String,
    var alias : String,
)
{
//    fun asNetworkModel(): NetworkCard {
//        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault(Locale.Category.FORMAT))
//
//      return NetworkWallet(
//        )
//    }
}