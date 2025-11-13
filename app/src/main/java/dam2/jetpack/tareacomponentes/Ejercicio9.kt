package dam2.jetpack.tareacomponentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Speaker


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Ejercicio9() {
    FlowRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
    ) {
        var tamanio by rememberSaveable { mutableStateOf(48f) } // tamaño inicial visible

        Slider(
            value = tamanio,
            onValueChange = { tamanio = it },
            valueRange = 24f..128f
        )

        Spacer(Modifier.padding(12.dp))

        Icon(
            imageVector = Icons.Filled.Speaker,
            contentDescription = "Altavoz",
            modifier = Modifier.size(tamanio.dp)
        )
    }
}
