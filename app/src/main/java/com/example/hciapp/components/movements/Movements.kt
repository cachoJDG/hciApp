package com.example.hciapp.components.movements

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hciapp.data.model.Movement

@Composable
fun MovimientosList(movimientos: List<Movement>, modifier: Modifier) {
        movimientos.forEach { movimiento ->
            MovimientoCard(movimiento = movimiento)
        }
}