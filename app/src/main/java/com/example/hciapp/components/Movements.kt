import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import com.example.hciapp.components.Movimiento
import com.example.hciapp.components.MovimientoCard

@Composable
fun MovimientosList(movimientos: List<Movimiento>, modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        movimientos.forEach { movimiento ->
            MovimientoCard(movimiento = movimiento)
        }
    }
}