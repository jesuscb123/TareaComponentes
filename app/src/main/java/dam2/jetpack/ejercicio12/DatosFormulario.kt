package dam2.jetpack.ejercicio12

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DatosFormulario(
    val nombre: String,
    val correo: String,
    val edad: Int,
    val lenguaje: String,
    val preferencias: Map<String, Boolean>
) : Parcelable
