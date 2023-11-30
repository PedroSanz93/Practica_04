package screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class elementosLista(
    val id: Int,
    val label: String,
    var initialChecked: Boolean=false){
    var checked by mutableStateOf(initialChecked)
}
