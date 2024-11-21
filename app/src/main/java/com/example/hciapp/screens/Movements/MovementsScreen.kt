import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hciapp.components.BalloonTopBar
import com.example.hciapp.components.Movimiento

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovimientosScreen() {
    Scaffold(
        topBar = {
            BalloonTopBar(title = "Movimientos", onBackClick = {})
        }
    ) { paddingValues ->
        val movimientos = listOf(
            Movimiento("Compra", "Supermercado", "2023-10-01"),
            Movimiento("Venta", "Mercado", "2023-10-02"),
            Movimiento("Transferencia", "Banco", "2023-10-03")
        )

        MovimientosList(
            movimientos = movimientos,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
fun MovimientosScreenPreview() {
    MovimientosScreen()
}