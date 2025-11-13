package dam2.jetpack.tareacomponentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun Ejercicio5(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        var finalizado by rememberSaveable { mutableStateOf(false) }
        var comenzar by rememberSaveable { mutableStateOf(false) }
        if (comenzar){
            CircularProgressIndicator()
            LaunchedEffect(Unit) { //Lanzamos una corrutina del sistema para hacer que parezca que está tardando en cargar.
                delay(3000)
                finalizado = true
                comenzar = false
            }
        }else if (finalizado){
            Text("Carga completada")
        }

        Button(onClick ={
            comenzar = true
        }) {Text("Comenzar carga")}

    }
}