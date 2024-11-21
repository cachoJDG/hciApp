package com.example.hciapp.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.hciapp.ui.theme.HciAppTheme
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun QrScreen(modifier: Modifier = Modifier) {
    var resultadoEscaneo by remember { mutableStateOf("") }
    var mensajeGenerarQR by remember { mutableStateOf("") }
    val scanLauncher = rememberLauncherForActivityResult(
        contract = ScanContract(),
        onResult = { result ->
            resultadoEscaneo = result.contents ?: "No se pudo escanear"
        }
    )

    var showPopup by remember { mutableStateOf(false) }
    val qrImage: Painter = painterResource(id = com.example.hciapp.R.drawable.testqr)


    HciAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Botón para escanear QR
                Button(
                    onClick = {
                        scanLauncher.launch(ScanOptions())
                        mensajeGenerarQR = "" // Limpia el mensaje de generar QR
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Escanear")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botón para generar QR quiero que me imprima en pantalla un dialog de qr
                Button(onClick = { showPopup = true }) {
                    Text("Generar QR")
                }

                if (showPopup) {
                    Popup(onDismissRequest = { showPopup = false }) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Escanea este código QR", style = MaterialTheme.typography.bodyLarge)
                                Spacer(modifier = Modifier.height(16.dp))
                                Image(
                                    painter = qrImage,
                                    contentDescription = "QR Code",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f)
                                        .clickable { showPopup = false } // Cierra el popup al hacer clic en la imagen
                                )
                            }

                        }
                    }
                }



                Spacer(modifier = Modifier.height(24.dp))

                // Muestra el resultado del escaneo o el mensaje de generar QR
                Text(
                    text = when {
                        resultadoEscaneo.isNotEmpty() -> "Resultado: $resultadoEscaneo"
                        mensajeGenerarQR.isNotEmpty() -> mensajeGenerarQR
                        else -> ""
                    },
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
