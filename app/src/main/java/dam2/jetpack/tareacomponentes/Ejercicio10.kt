package dam2.jetpack.tareacomponentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio10(){

        Card(Modifier.fillMaxSize()){
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                Image(
                    painterResource(R.drawable.entrenadorpokemon),
                    "Entrenador Pokemon"
                )
                Spacer(Modifier.padding(10.dp))
                Text("Ash Ketchum", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("Pueblo Paleta (Kanto)", fontSize = 15.sp)
                Spacer(Modifier.padding(7.dp))
                Text("Medallas", fontWeight = FontWeight.Bold)
                HorizontalDivider()
                Spacer(Modifier.padding(10.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
                    Medallas(painterResource(R.drawable.medallroca), "roca")
                    Medallas(painterResource(R.drawable.medallcascada), "cascada")
                    Medallas(painterResource(R.drawable.medallatrueno), "trueno")
                    Medallas(painterResource(R.drawable.medallarcoiris), "arcoíris")

                }

                Spacer(Modifier.padding(10.dp))

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
                    Medallas(painterResource(R.drawable.medallalma), "alma")
                    Medallas(painterResource(R.drawable.medallpantano), "pantano")
                    Medallas(painterResource(R.drawable.medallvolcan), "volcan")
                    Medallas(painterResource(R.drawable.medalltierra), "tierra")

                }


            }
        }
}

@Composable
fun Medallas(medalla: Painter, texto: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Image(medalla, texto, Modifier.size(40.dp))
        Text(texto)
    }
}

