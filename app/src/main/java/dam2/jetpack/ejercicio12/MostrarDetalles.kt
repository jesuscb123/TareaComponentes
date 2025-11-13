package dam2.jetpack.ejercicio12

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MostrarDetalles(navController: NavHostController){

    val datos = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<DatosFormulario>("datosFormulario")

    if (datos != null){
            Card(modifier = Modifier.fillMaxSize()){
            Column(Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                LetraBold("Nombre")
                Text(datos.correo)
                HorizontalDivider()
                LetraBold("Edad")
                Text("${datos.edad}")
                HorizontalDivider()
                LetraBold("Lenguaje favorito")
                Text(datos.lenguaje)
                HorizontalDivider()
                LetraBold("Preferencias")
                val preferencias = datos.preferencias.filterValues { it }.keys.joinToString(", ")

                Text(preferencias)
                }

            }
    }
}

@Composable
fun LetraBold(texto: String){
    Text(texto, fontWeight = FontWeight.Bold, fontSize = 20.sp)
}