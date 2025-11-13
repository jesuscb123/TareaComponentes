package dam2.jetpack.tareacomponentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Ejercicio11(){
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        var verCuadroDialogo by rememberSaveable { mutableStateOf(false) }
        var verImagen by rememberSaveable { mutableStateOf(false) }

        if (verCuadroDialogo){
            AlertDialog(
                onDismissRequest = { verCuadroDialogo = false },
                title = {
                    Text("Elige la pastilla")
                },
                text = {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                        Text(
                            "Pastilla roja",
                            color = Color.Blue,
                            modifier = Modifier.clickable(onClick = {
                                verImagen = true
                                verCuadroDialogo = false //Cerramos el diálogo cuando haga click
                            })
                            )
                        Text(
                            "Pastilla azul",
                            color = Color.Red, modifier = Modifier.clickable(onClick = {
                                verCuadroDialogo = false
                            }))
                    }
                },
                confirmButton = {
                    TextButton(onClick = { verCuadroDialogo = false }){ Text("Confirmar")  }
                },
                dismissButton = {
                    TextButton(onClick ={
                        verCuadroDialogo = false
                    }) { Text("Cancelar") }
                }
            )
        }

        if (verImagen){
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Image(painterResource(R.drawable.morfeo2), "morfeo")
                Text("Has entrado en matrix", color = Color.Red)
            }
        }

        Button(onClick = {
            verCuadroDialogo = true
        }) {Text("Mostrar dialogo") }
    }

}