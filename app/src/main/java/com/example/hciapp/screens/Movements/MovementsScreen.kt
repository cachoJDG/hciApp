import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hciapp.components.general.BalloonTopBar
import com.example.hciapp.components.movements.MovimientosList
import com.example.hciapp.data.model.Movement

@Composable
fun MovimientosScreen(navController: NavController) {
    Scaffold(
        topBar = {
            BalloonTopBar(title = "Movimientos", onBackClick = {navController.popBackStack()})
        }
    ) { paddingValues ->
        val movimientos = listOf(
            Movement("Compra", "Supermercado", "2023-10-01"),
            Movement("Venta", "Mercado", "2023-10-02"),
            Movement("Transferencia", "Banco", "2023-10-03")
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 16.dp) // Add padding to avoid overlap
        ) {
            MovimientosList(
                movimientos = movimientos,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
