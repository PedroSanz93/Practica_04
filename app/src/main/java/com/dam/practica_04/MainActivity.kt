package com.dam.practica_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dam.practica_04.ui.theme.Practica_04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica_04Theme {

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// llamada a la clase que me sirve como plantilla y se le pasan los parametros de la lista de abajo
private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

// lista de imagenes e iconos
private val imagenes = listOf(
    R.drawable.fotoplato1 to R.string.fotoplato1,
    R.drawable.fotoplato2 to R.string.fotoplato2,
    R.drawable.fotoplato3 to R.string.fotoplato3,
    R.drawable.fotoplato4 to R.string.fotoplato4,
    R.drawable.ilustracion1 to R.string.ilustracion1,
    R.drawable.ilustracion2 to R.string.ilustracion2,
    R.drawable.ilustracion3 to R.string.ilustracion3,
    R.drawable.ilustracion3 to R.string.ilustracion3,
).map { DrawableStringPair(it.first, it.second) }

//  ------------> ME HE QUEDADO POR METER LOS COLORES DE LA APP Y SIGUE EL CUERPO DE CADA FUNCION

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica_04Theme {
        Greeting("Android")
    }
}