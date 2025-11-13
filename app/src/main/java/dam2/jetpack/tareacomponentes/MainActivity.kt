package dam2.jetpack.tareacomponentes

import Ejercicio7
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dam2.jetpack.tareacomponentes.ui.theme.TareaComponentesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InicioApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InicioApp() {
    val navigation = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed) // Estado del menú lateral (abierto o cerrado)
    val scope = rememberCoroutineScope()

    val ejercicios = listOf(
        "Ejercicio1",
        "Ejercicio2",
        "Ejercicio3",
        "Ejercicio4",
        "Ejercicio5",
        "Ejercicio6",
        "Ejercicio7",
        "Ejercicio8",
        "Ejercicio9",
        "Ejercicio10",
        "Ejercicio11"
    )

    TareaComponentesTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text(
                        "Ejercicios",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                    ejercicios.forEach { ejercicio ->
                        NavigationDrawerItem(
                            label = { Text(ejercicio) },
                            selected = false,
                            onClick = {
                                navigation.navigate(ejercicio) // Navega a la tarea seleccionada.

                                scope.launch { drawerState.close() } // Cierra el menú en pulsar en alguna tarea.
                            }
                        )
                    }
                }
            }
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = { Text("Tarea Componentes") },
                        navigationIcon = {
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(Icons.Default.Menu, contentDescription = "Abrir menú")
                            }
                        }
                    )
                }
            ) { innerPadding ->
                NavHost(
                    navController = navigation,
                    startDestination = "Ejercicio1",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable("Ejercicio1") { Ejercicio1() }
                    composable("Ejercicio2") { Ejercicio2() }
                    composable("Ejercicio3") { Ejercicio3() }
                    composable("Ejercicio4") { Ejercicio4() }
                    composable("Ejercicio5") { Ejercicio5() }
                    composable("Ejercicio6") { Ejercicio6() }
                    composable("Ejercicio7") { Ejercicio7() }
                    composable("Ejercicio8") { Ejercicio8() }
                    composable("Ejercicio9") { Ejercicio9() }
                    composable("Ejercicio10") { Ejercicio10() }
                    composable("Ejercicio11") { Ejercicio11() }

                }
            }
        }
    }
}
