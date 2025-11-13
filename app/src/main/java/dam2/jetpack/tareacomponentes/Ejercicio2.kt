package dam2.jetpack.tareacomponentes

import android.R.attr.value
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Ejercicio2(){
    var nombre by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text("Registrarse")

        Text("Nombre")
        IntroducirTexto(nombre) {
            nombre = it
        }

        Text("Email")
        IntroducirTexto(email) {
            email = it
        }
        Text("contraseña")
        IntroducirTexto(password) {
            password = it
        }

    }
}

@Composable
fun IntroducirTexto(texto: String, cambiarTexto: (String) -> Unit) {
    TextField(
        texto, onValueChange = cambiarTexto,
        modifier = Modifier.border(
            width = 5.dp, color = if (texto.isEmpty()){
                Color.Red
            } else {
                Color.DarkGray
            }
        )
        )
}