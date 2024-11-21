package com.example.hciapp.screens.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.hciapp.ui.theme.HciAppTheme

@Composable
fun CreditCardsScreen(modifier: Modifier = Modifier) {
    // Lista de tarjetas cargadas, cada tarjeta contiene un nombre y los últimos 4 dígitos
    val tarjetas = listOf(
        Tarjeta("Visa", "1234"),
        Tarjeta("Mastercard", "5678"),
        Tarjeta("American Express", "9876")
    )

    // Estado para mostrar el diálogo para agregar tarjeta
    var showAddCardDialog by remember { mutableStateOf(false) }

    HciAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Mis Tarjetas",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Lista de tarjetas
                LazyColumn(modifier = Modifier.fillMaxHeight(0.8f)) {
                    items(tarjetas.size) { index ->
                        TarjetaItem(tarjeta = tarjetas[index])
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                // Botón para agregar una tarjeta
                FloatingActionButton(
                    onClick = { showAddCardDialog = true },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Icon(
                        painter = painterResource(id = com.example.hciapp.R.drawable.baseline_add_24),
                        contentDescription = "Agregar tarjeta",
                        tint = Color.White
                    )
                }

                // Mostrar el diálogo para agregar tarjeta
                if (showAddCardDialog) {
                    AddCardDialog(onDismiss = { showAddCardDialog = false })
                }
            }
        }
    }
}

@Composable
fun TarjetaItem(tarjeta: Tarjeta) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
//        elevation = CardDefaults.elevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Aquí podrías agregar un logo de tarjeta, por ejemplo
            Image(
                painter = painterResource(id = com.example.hciapp.R.drawable.outline_credit_card_24),
                contentDescription = "Logo de tarjeta",
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Información de la tarjeta
            Column {
                Text(text = tarjeta.nombre, style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = "**** **** **** ",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun AddCardDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Agregar tarjeta") },
        text = {
            Column {
                Text("Ingresa los detalles de la tarjeta")
                Spacer(modifier = Modifier.height(16.dp))

                // Aquí agregarías campos para ingresar datos de la tarjeta
                // Por ejemplo: Nombre, Número de tarjeta, Fecha de vencimiento, etc.
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Número de tarjeta") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Nombre en tarjeta") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancelar")
                    }
                    TextButton(onClick = {
                        // Aquí puedes agregar lógica para agregar la tarjeta
                        onDismiss()
                    }) {
                        Text("Agregar")
                    }
                }
            }
        },
        confirmButton = {},
        dismissButton = {},
    )
}

data class Tarjeta(val nombre: String, val últimosCuatro: String)

@Preview
@Composable
fun PreviewCreditCardsScreen() {
    CreditCardsScreen()
}
