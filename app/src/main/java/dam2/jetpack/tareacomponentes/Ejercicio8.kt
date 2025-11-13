package dam2.jetpack.tareacomponentes

import android.provider.MediaStore
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun  Ejercicio8(){
    var listaOpciones = listOf("Tarjeta", "Paypal", "Transferencia")
    var metodoSeleccionado by rememberSaveable {mutableStateOf("")}
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(metodoSeleccionado)
        Spacer(Modifier.padding(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            listaOpciones.forEach { opcion ->
                Column(){
                    Text(opcion)
                    RadioButton(
                        selected = (metodoSeleccionado == opcion),
                        onClick = {metodoSeleccionado = opcion}
                    )
                }
            }
        }
    }
}


