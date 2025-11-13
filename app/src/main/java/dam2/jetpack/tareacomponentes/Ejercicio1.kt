package dam2.jetpack.tareacomponentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Ejercicio1(){
    var nombre by rememberSaveable { mutableStateOf("") }
    var confirmado by rememberSaveable { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        if (!confirmado){
            IntroducirNombre(
                nombre,
                cambiarNombre = {nombre = it},
                confirmar = {confirmado = it}
            )
        }else{
            Text(
                "¡Bienvenido! ${nombre.uppercase()}",
                textDecoration = TextDecoration.Underline,
                fontFamily = FontFamily.Monospace,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 31.sp
            )
            Text(
                "¿Qué deseas hacer?",
                modifier = Modifier.padding(30.dp),
                textDecoration = TextDecoration.None,
                color = Color.Magenta,
                fontSize = 30.sp
                )
            HorizontalDivider()

            Text(
                "Iniciar aplicación",
                modifier = Modifier.padding(30.dp),
                textDecoration = TextDecoration.None,
                color = Color.Magenta,
                fontSize = 25.sp
            )

            HorizontalDivider()

            Text(
                "Activar geolocalización",
                modifier = Modifier.padding(30.dp),
                textDecoration = TextDecoration.None,
                color = Color.Red,
                fontSize = 25.sp
            )

            HorizontalDivider()

            Text(
                "Hacer foto",
                modifier = Modifier.padding(30.dp),
                textDecoration = TextDecoration.None,
                color = Color.Blue,
                fontSize = 25.sp
            )

        }
    }
}


@Composable
fun IntroducirNombre(nombre: String, cambiarNombre: (String) -> Unit, confirmar: (Boolean) -> Unit){
    Text("Introduce tu nombre")
    TextField(value = nombre, onValueChange = cambiarNombre)
    Spacer(Modifier.padding(5.dp))
    Button(onClick = {
        confirmar(true)
    }){
        Text("Confirmar")
    }
}
