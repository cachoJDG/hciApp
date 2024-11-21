package com.example.hciapp.components.homeScreen

import com.example.hciapp.components.movements.MovimientosList
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.hciapp.data.model.Movement

@Composable
fun WrappedMovementsBox(movements: List<Movement>) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Movements",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            RecentMovementsBox(movements)
        }
    }
}

@Composable
fun RecentMovementsBox(movements: List<Movement>) { 
    val recentMovements = movements.takeLast(3).reversed()
            MovimientosList(recentMovements, Modifier)
}

@Preview
@Composable
fun WrappedMovementsBoxPreview() {
    WrappedMovementsBox(
        movements = listOf(
            Movement("Compra", "Supermercado", "2023-10-01"),
            Movement("Venta", "Mercado", "2023-10-02"),
            Movement("Transferencia", "Banco", "2023-10-03"),
            Movement("Compra", "Supermercado", "2023-10-01"),
            Movement("Venta", "Mercado", "2023-10-02")
        )
    )
}