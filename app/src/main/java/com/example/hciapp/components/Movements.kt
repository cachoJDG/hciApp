import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import com.example.hciapp.data.model.Movement

@Composable
fun MovimientosList(movimientos: List<Movement>, modifier: Modifier) {
        movimientos.forEach { movimiento ->
            MovimientoCard(movimiento = movimiento)
        }
}