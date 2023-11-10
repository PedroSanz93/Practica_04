package com.dam.practica_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.practica_04.ui.theme.Practica_04Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica_04Theme {
                principalAPP()
            }
        }
    }
}
// "MAIN" DE LA APP QUE MUESTRA EN EL EMULADOR
@Composable
fun principalAPP(){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        item() {
            barraBuscador()
        }
        item(){
            tituloPlatosDestacados()
        }
        item {
            platosDestacadosRow()
        }

    }

}
// BARRA BUSCADOR
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraBuscador(modifier: Modifier= Modifier)
{
    TextField(
        value="",
        onValueChange= {},
        leadingIcon={
            Icon(imageVector = Icons.Default.Search,
                contentDescription= null)
        },
        placeholder = {
            Text("Buscar")
        },
        modifier= modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}
// ELEMETO INDIVIDUAL LAZY ROW PLATOS DESTACADOS
@Composable
fun platosDestacadosElemento(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
)
{
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier)
    {
        Image(painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(88.dp)
                    .clip(CircleShape)
        )
        Text(text= stringResource(text),
            modifier= Modifier.paddingFromBaseline(top= 24.dp, bottom= 8.dp),
            style= MaterialTheme.typography.bodyMedium)

    }
}
// TITULO DEL LAZY ROW PLATOS DESTACADOS
@Composable
fun tituloPlatosDestacados(){
    Surface(
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.secondary),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize()
    ) {
        Text("PLATOS DESTACADOS",
            textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
    }
}
// LAZY ROW, ANIMACION Y LISTA DE IMAGENES PLATOS DESTACADOS
@Composable
fun platosDestacadosRow(modifier: Modifier = Modifier)
{
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal= 16.dp),
                modifier= modifier
                    .padding(horizontal = 8.dp)
    ){
        items(imagenes){// Llama a la lista IMAGENES QUE ES DONDE ESTA LOS QUE QUIERO
                item -> platosDestacadosElemento(item.drawable, item.text)
        }
    }
}
// ICONOS CON ANIMACIONES GUAPAS

// TITULO DE LAS ILUSTRACIONES DE LOS PLATOS

// ELEMENTO GRID CON LAS ILUSTRACIONES DE LOS PLATOS
@Composable
fun ilustracionElemento(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
){
    Surface(shape= MaterialTheme.shapes.medium,
        modifier= modifier){
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(200.dp)){
            Image(painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp))
            Text(text= stringResource(text),
                style= MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal= 16.dp)
            )
        }
    }

}



// llamada a la clase que me sirve como plantilla y se le pasan los parametros de la lista de abajo
private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
// LISTA FOTO PLATOS
private val imagenes = listOf(
    R.drawable.fotoplato1 to R.string.fotoplato1,
    R.drawable.fotoplato2 to R.string.fotoplato2,
    R.drawable.fotoplato3 to R.string.fotoplato3,
    R.drawable.fotoplato4 to R.string.fotoplato4,
    R.drawable.fotoplato5 to R.string.fotoplato5,
    R.drawable.fotoplato6 to R.string.fotoplato6
).map { DrawableStringPair(it.first, it.second) }
// LISTA ILUSTRACIONES
private val imagenes2 = listOf(
    R.drawable.ilustracion1 to R.string.ilustracion1,
    R.drawable.ilustracion2 to R.string.ilustracion2,
    R.drawable.ilustracion3 to R.string.ilustracion3,
    R.drawable.ilustracion4 to R.string.ilustracion4,
    R.drawable.ilustracion5 to R.string.ilustracion5
).map { DrawableStringPair(it.first, it.second) }
// LISTA ICONOS
private val iconos = listOf(

    R.drawable.ic1 to R.string.ic1,
    R.drawable.ic2 to R.string.ic2,
    R.drawable.ic3 to R.string.ic3
).map { DrawableStringPair(it.first, it.second) }
// LISTA FOTOS USUARIO
private val usuariosImagen = listOf(

    R.drawable.us1 to R.string.us1,
    R.drawable.us2 to R.string.us2,
).map { DrawableStringPair(it.first, it.second) }
// PREVIEW BARRA BUSCADOR
@Preview(showBackground = true)
@Composable
fun barraBuscadorPreview() {
    barraBuscador()

}
// PREVIEW ELEMENTO INDIVIDUAL PLATOS DESTACADOS
@Preview(showBackground = true)
@Composable
fun platosDestacadosElementoPreview(){
    platosDestacadosElemento(drawable= R.drawable.fotoplato1,
                                text= R.string.fotoplato1)
}
// PREVIEW TITULO PLATOS DESTACADOS
@Preview(showBackground = true)
@Composable
fun tituloPlatosDestacadosPreview(){
    tituloPlatosDestacados()
}
// PREVIEW LAZY ROW LISTA IMAGANES PLATOS DESTACADOS
@Preview(showBackground = true)
@Composable
fun platosDestacadosRowPreview(){
    platosDestacadosRow()
}

// PREVIEW ELEMENTO GRID ILUSTRACIONES DE PLATOS
@Preview(showBackground = true)
@Composable
fun ilustracionElementoPreview(){
    ilustracionElemento(modifier= Modifier.padding(8.dp),
                        drawable = R.drawable.ilustracion1,
                        text = R.string.ilustracion1)
}



