package dam2.jetpack.tareacomponentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio4(){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically){

        ImagenTexto(painterResource(R.drawable.gtr1), "gtr atrás",  Modifier.weight(1f)) //Indicamos que todos tengan el mismo peso para que ocupe el espacio de forma equitativa.
        ImagenTexto(painterResource(R.drawable.gtr2), "gtr delantero",  Modifier.weight(1f))
        ImagenTexto(painterResource(R.drawable.gtr3), "gtr lateral",  Modifier.weight(1f))

    }
}

@Composable
fun ImagenTexto(imagen: Painter, description: String, modifier: Modifier = Modifier){
    var iconPulsado by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = imagen, description, Modifier.size(100.dp))
        Spacer(Modifier.padding(4.dp))
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(description)
            Icon(
                if (iconPulsado){ //Si el icono ha sido pulsado cambia el estado de la variable iconPulsado para ahcer aparecer un icono u otro.
                    Icons.Default.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                },
                "Favorito",
                modifier = Modifier.clickable(onClick = {
                    iconPulsado = !iconPulsado
                })
                )
        }
    }
}