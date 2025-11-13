package dam2.jetpack.ejercicio12

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dam2.jetpack.ejercicio12.ui.theme.Ejercicio12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            IniciarApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IniciarApp(){
    var dark by rememberSaveable { mutableStateOf(false) }
    var navController = rememberNavController()

    Ejercicio12Theme(darkTheme = dark) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                            Text("Formulario")
                            Switch(dark, onCheckedChange = {
                                dark = it
                            })
                        }
                })
            }
            ) { innerPadding ->
            Surface(
                modifier = Modifier.padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ){
                NavHost(
                    navController = navController,
                    startDestination = "formulario"
                ){
                    composable("formulario") {Formulario(navController)}
                    composable ("detalles") {MostrarDetalles(navController)}


                }

            }

        }
    }
}

@Composable
fun Formulario(navController: NavHostController){
    var nombre by rememberSaveable { mutableStateOf("") }
    var correo by rememberSaveable { mutableStateOf("") }
    var slider by rememberSaveable { mutableFloatStateOf(0f) }
    var lenguajeSelect by rememberSaveable { mutableStateOf("") }
    var listaLenguajes = listOf<String>("Kotlin", "Java", "Python")
    val preferencias = remember {
        mutableStateMapOf(
            "Deportes" to false,
            "Música" to false,
            "Televisión" to false,
            "Videojuegos" to false,
            "Carnaval" to false
        )
    }
    var mostrarDetalles by rememberSaveable { mutableStateOf(false) }
    var mostrarDialogo by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(text = "Nombre")
        TextField(nombre, onValueChange = {nombre = it}, Modifier.border(
            width = 5.dp, color = if(nombre.isEmpty()) Color.Red else Color.Gray
        ))
        Text(text = "Correo")
        TextField(correo, onValueChange = {correo = it}, Modifier.border(
                width = 5.dp, color = if(correo.isEmpty()) Color.Red else Color.Gray
        ))
        HorizontalDivider()
        Text("Edad: ${slider.toInt()}")
        Slider(
            value = slider,
            onValueChange = {slider = it},
            valueRange = 0f..99f,
        )
        HorizontalDivider()
        Text("Indica los temas que más te interesan")
        Preferencias(preferencias)
        HorizontalDivider()
        CrearRadioButton(listaLenguajes, lenguajeSelect){
            lenguajeSelect = it
        }
        HorizontalDivider()
        Button(
            onClick = { mostrarDialogo = true },
            enabled = todoCorrecto(nombre, correo, lenguajeSelect)
            ) { Text("Enviar") }

        if (mostrarDialogo) {
            CrearAlertDialog(
                confirmar = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "datosFormulario", DatosFormulario(
                            nombre,
                            correo,
                            slider.toInt(),
                            lenguajeSelect,
                            preferencias
                        )
                    )
                    navController.navigate("detalles")
                },
                cancelar = {
                    mostrarDialogo = false
                }
            )
        }
    }
}

fun todoCorrecto(nombre: String, correo: String, lenguajeSeleccionado: String): Boolean{
   return if (nombre.isEmpty() && correo.isEmpty() && lenguajeSeleccionado.isEmpty())  false else true

}


@Composable
fun Preferencias(preferencias: MutableMap<String, Boolean>) {

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        preferencias.forEach { (aficion, checked) ->
            CrearCheckBox(aficion, checked) {
                preferencias[aficion] = it
            }
        }
    }
}


@Composable
fun CrearCheckBox(
    categoria: String,
    activado: Boolean,
    cambiarEstado: (Boolean) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(categoria)
        Checkbox(
            checked = activado,
            onCheckedChange = cambiarEstado,
            enabled = true
        )
    }
}

@Composable
fun CrearRadioButton(listaOpciones: List<String>, lenguajeSeleccionado: String, seleccionarLenguaje: (String) -> Unit){
    Row(
        Modifier.fillMaxWidth().padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        listaOpciones.forEach { opcion ->
            Text(opcion)
            RadioButton(
                selected = lenguajeSeleccionado == opcion,
                onClick = {seleccionarLenguaje(opcion)}
            )
        }
    }
}

@Composable
fun CrearAlertDialog(confirmar: () -> Unit, cancelar: () -> Unit) {
        AlertDialog(
            onDismissRequest = {cancelar()} ,
            title = { Text("Título") },
            text = { Text("¿Deseas ver los detalles?") },
            confirmButton = {
                TextButton(onClick = {
                    confirmar()
                }) {
                    Text("Confirmar")

                }
            },
            dismissButton = {
                TextButton(onClick = {
                    cancelar()
                }) {
                    Text("Cancelar")
                }
            }
        )
    }






