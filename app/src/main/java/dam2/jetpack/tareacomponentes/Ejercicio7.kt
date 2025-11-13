import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Ejercicio7() {
    val aficiones = remember {
        mutableStateMapOf(
            "Deportes" to false,
            "Música" to false,
            "Televisión" to false,
            "Videojuegos" to false,
            "Carnaval" to false
        )
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Temas que te pueden interesar")
        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            aficiones.toList().forEach { (aficion, checked) ->
                CrearCheckBox(
                    aficion = aficion,
                    activado = checked,
                    cambiarEstado = { nuevoEstado -> aficiones[aficion] = nuevoEstado }
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        val seleccionados = aficiones.filterValues { it }.keys //Filtramos aquellas claves del diccionario que su valor sea true
        Text(
            text = if (seleccionados.isEmpty()) "Ninguna afición seleccionada"
            else "Seleccionadas: ${seleccionados.joinToString(", ")}" // Le hacemos jointoStirng para que aparezca cada afición separados por ,.
        )
    }
}

@Composable
fun CrearCheckBox(
    aficion: String,
    activado: Boolean,
    cambiarEstado: (Boolean) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(aficion)
        Checkbox(
            checked = activado,
            onCheckedChange = cambiarEstado,
            enabled = true
        )
    }
}
