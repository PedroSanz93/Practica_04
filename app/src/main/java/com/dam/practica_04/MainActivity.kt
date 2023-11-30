package com.dam.practica_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.practica_04.ui.theme.Practica_04Theme
import navegacion.navegacion
import screen.principalAPP
import screen.principalAPP2
// MAIN
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navegacion()
        }
    }
}
/*
// APP DE LA PRACTICA 4 SIN EVENTOS
@Composable
fun principalAPP(windowSize: WindowSizeClass){
    when(windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact ->{
            botoneraIconos()
        }
        WindowWidthSizeClass.Medium ->{
            botonera()
        }
    }
}

// SECCION RANURA PRINCIPAL
@Composable
fun seccionPrincipal(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier){
        Text(stringResource(title),
            style= MaterialTheme.typography.titleMedium,
            modifier= Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .padding(horizontal = 16.dp))
        content()
    }
}

//PANTALLA PRINCIPAL
@Composable
fun pantallaAPP(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Para el fondo del chat
        Image(
            painter = painterResource(id = R.drawable.fondopantalla),
            contentScale = ContentScale.FillBounds,
            contentDescription = "fondo",
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier.verticalScroll(rememberScrollState())) {
            Spacer(Modifier.height(16.dp))
            barraBuscador(Modifier.padding(horizontal = 16.dp))
            seccionPrincipal(title = R.string.TITULO1) {
                platosDestacadosRow()
            }
            seccionPrincipal(title = R.string.TITULO2) {
                ilustracionesGrid()
            }
            seccionPrincipal(title = R.string.titulorecetas) {
                recetario1()
                recetario2()
                recetario3()
            }
            seccionPrincipal(title = R.string.TITULO3) {
                concinerosDestacadosRow()
            }

            Spacer(Modifier.height(16.dp))
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

// ICONOS BARRA NAVEGACION
@Composable
private fun barraNavIconos(modifier: Modifier = Modifier) {
    NavigationBar(modifier= modifier, containerColor = MaterialTheme.colorScheme.secondary) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null)},
            label= { Text(text= stringResource(R.string.ic1))}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)},
            label= { Text(text= stringResource(R.string.ic2))}
        )
        // boton favoritos

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null)},
            label= { Text(text= stringResource(R.string.ic3))}
        )
    }
}

// BOTONERA ICONOS
@Composable
fun botoneraIconos() {
    Practica_04Theme {
        Scaffold(
            bottomBar = { barraNavIconos()}
        ) {
                padding -> pantallaAPP(Modifier.padding(padding))
        }
    }

}

// RAIL PARA ICONOS VERTICAL/HORIZONTAL NAVEGACION
@Composable
private fun botoneraIconosRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            NavigationRailItem(
                label = { Text(stringResource(R.string.ic1)) },
                selected = true,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
            )
            NavigationRailItem(
                label = { Text(stringResource(R.string.ic2)) },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) }
            )
            NavigationRailItem(
                label = { Text(stringResource(R.string.ic3)) },
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) }
            )
        }
    }
}
// BOTONERA COMPLETA
@Composable
fun botonera(){
    Practica_04Theme{
        Surface(color= MaterialTheme.colorScheme.secondary) {
            Row{
                botoneraIconosRail()
                pantallaAPP()
            }
        }
    }
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
// TITULO DE LAS ILUSTRACIONES DE LOS PLATOS
@Composable
fun tituloIlustraciones(){
    Surface(
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.secondary),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize()
    ) {
        Text("ILUSTRACIONES",
            textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
    }
}
// ELEMENTO GRID CON LAS ILUSTRACIONES DE LOS PLATOS ANDALUCES
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
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp)))
            Text(text= stringResource(text),
                style= MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal= 20.dp)
            )
        }
    }
}
// GRID DE ILUSTRACIONES
@Composable
fun ilustracionesGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(rows= GridCells.Fixed(2),
        contentPadding= PaddingValues(horizontal= 16.dp),
        horizontalArrangement= Arrangement.spacedBy(16.dp),
        verticalArrangement= Arrangement.spacedBy(20.dp),
        modifier= modifier.height(168.dp)){
        items(imagenes2){
                item -> platosDestacadosElemento(item.drawable, item.text,
            modifier= modifier.height(80.dp))
        }
    }
}

// Funcion Ventana de consejo para recetas
@Composable
fun ventanaConsejo(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.secondary),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = taskName
            )
            // boton cerrar
            IconButton(
                onClick = onClose,
                modifier = Modifier.align(Alignment.Bottom)
            ) {
                // icono boton cerrar
                Icon(Icons.Filled.Close, contentDescription = "Close")
            }
        }
    }
}

// SURFACES EXPANDIBLES CON LAS RECETAS Y LOGICAS PARA VENTANACONSEJO
@Composable
fun recetario1() {
    // variable para expandir texto en false para que aparezca contraido
    var isExpanded by remember { mutableStateOf(false) }
    // variable para mostrar consejo en false para que no aparezca inicialmente
    var mostrarConsejo by remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.tertiary),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(10.dp)
            .animateContentSize()
    ) {
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "TORTILLA DE PATATAS",
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Pasos a seguir: \n" +
                                "Corta y fríe patatas en rodajas en aceite de oliva hasta que estén tiernas.\n" +
                                "Pica cebolla y bate huevos con sal.\n" +
                                "Mezcla patatas y cebolla con huevos batidos.\n" +
                                "Cocina en una sartén hasta que los bordes cuajen.\n" +
                                "Voltea la tortilla para cocinar el otro lado.\n" +
                                "Cocina hasta que esté cuajada pero jugosa por dentro.\n" +
                                "Sirve caliente o a temperatura ambiente. ¡Disfruta!",
                        // si isExpande es true se expande entero y si es false se contrae y muestra el titulo
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        modifier = Modifier.padding(2.dp)
                    )
                }
                // si onClick que es clickar el boton esta en estado diferente
                IconButton(
                    onClick = { mostrarConsejo = !mostrarConsejo },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    // icono de la campanita
                    Icon(Icons.Filled.Notifications, contentDescription = "Consejo")
                }
            }
            // si es true muestra el consejo
            if (mostrarConsejo) {
                ventanaConsejo(
                    taskName = "Recuerda para esta receta hacer el corte de la patata debe ser fino",
                    // cierra al clickar cerrar en ventanaConsejo
                    onClose = { mostrarConsejo = false },
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}
@Composable
fun recetario2(){
    // variable para expandir texto en false para que aparezca contraido
    var isExpanded by remember { mutableStateOf(false) }
    // variable para mostrar consejo en false para que no aparezca inicialmente
    var mostrarConsejo by remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.tertiary),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(10.dp)
            .animateContentSize()
    ) {
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "CARRILLADA",
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Preparación de la Carrillada:\n" +
                                "\n" +
                                "Sazona las carrilladas de cerdo con sal y pimienta.\n" +
                                "Dóralas en una sartén con aceite caliente hasta que estén doradas por ambos lados.\n" +
                                "Preparación de la Salsa:\n" +
                                "\n" +
                                "Pica cebolla, ajo y zanahoria.\n" +
                                "Sofríe estos ingredientes en la misma sartén hasta que estén tiernos.\n" +
                                "Añade vino tinto y caldo de carne. Deja cocinar hasta que la salsa se reduzca.\n" +
                                "Cocción de la Carrillada:\n" +
                                "\n" +
                                "Coloca las carrilladas en la salsa y cocina a fuego lento hasta que estén tiernas.\n" +
                                "Servir:\n" +
                                "\n" +
                                "Sirve las carrilladas bañadas en la salsa caliente.\n" +
                                "Acompaña con guarniciones al gusto. ¡Listo para disfrutar!",
                        // si isExpande es true se expande entero y si es false se contrae y muestra el titulo
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        modifier = Modifier.padding(2.dp)
                    )
                }
                // si onClick que es clickar el boton esta en estado diferente
                IconButton(
                    onClick = { mostrarConsejo = !mostrarConsejo },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    // icono de la campanita
                    Icon(Icons.Filled.Notifications, contentDescription = "Consejo")
                }
            }
            // si es true muestra el consejo
            if (mostrarConsejo) {
                ventanaConsejo(
                    taskName = "Si quieres añadir patata al guiso, recuerda añadir un tercio mas de caldo y vino tinto y esperar a que la patata quede blanda",
                    // cierra al clickar cerrar en ventanaConsejo
                    onClose = { mostrarConsejo = false },
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Composable
fun recetario3(){
    // variable para expandir texto en false para que aparezca contraido
    var isExpanded by remember { mutableStateOf(false) }
    // variable para mostrar consejo en false para que no aparezca inicialmente
    var mostrarConsejo by remember { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.tertiary),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(10.dp)
            .animateContentSize()
    ) {
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "COCIDO",
                        modifier = Modifier.padding(2.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Preparación de Ingredientes:\n" +
                                "\n" +
                                "Lava y corta vegetales como zanahorias, patatas y apio.\n" +
                                "Trocea carne de res, pollo y chorizo.\n" +
                                "Cocción del Caldo:\n" +
                                "\n" +
                                "Hierve la carne en agua con sal hasta que se forme un caldo sabroso.\n" +
                                "Añade las verduras y cocina a fuego medio hasta que estén tiernas.\n" +
                                "Cocido de Legumbres:\n" +
                                "\n" +
                                "Incorpora garbanzos y judías.\n" +
                                "Cocina hasta que las legumbres estén tiernas y sabrosas.\n" +
                                "Cocción de Embutidos:\n" +
                                "\n" +
                                "Agrega chorizo y morcilla al caldo para potenciar el sabor.\n" +
                                "Cocina hasta que los embutidos estén bien cocidos.\n" +
                                "Presentación:\n" +
                                "\n" +
                                "Sirve en platos hondos separando caldo, carne, verduras y legumbres.\n" +
                                "Acompaña con salsa de tomate y guindillas al gusto.\n" +
                                "¡Disfruta de este reconfortante cocido!",
                        // si isExpande es true se expande entero y si es false se contrae y muestra el titulo
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        modifier = Modifier.padding(2.dp)
                    )
                }
                // si onClick que es clickar el boton esta en estado diferente
                IconButton(
                    onClick = { mostrarConsejo = !mostrarConsejo },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    // icono de la campanita
                    Icon(Icons.Filled.Notifications, contentDescription = "Consejo")
                }
            }
            // si es true muestra el consejo
            if (mostrarConsejo) {
                ventanaConsejo(
                    taskName = "Importante: Reutiliza el avío para preparar cocretas de puchero, ideales para acompañar cualquier comida",
                    // cierra al clickar cerrar en ventanaConsejo
                    onClose = { mostrarConsejo = false },
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Composable
fun cocinerosDestacadosElemento(
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
fun tituloCocinerosDestacados(){
    Surface(
        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.secondary),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize()
    ) {
        Text("COCINEROS DEL MES",
            textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
    }
}
// LAZY ROW, ANIMACION Y LISTA DE IMAGENES PLATOS DESTACADOS
@Composable
fun concinerosDestacadosRow(modifier: Modifier = Modifier)
{
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal= 16.dp),
        modifier= modifier
            .padding(horizontal = 8.dp)
    ){
        items(cocineros){// Llama a la lista IMAGENES QUE ES DONDE ESTA LOS QUE QUIERO
                item -> cocinerosDestacadosElemento(item.drawable, item.text)
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
    R.drawable.ilustracion5 to R.string.ilustracion5,
    R.drawable.ilustracion6 to R.string.ilustracion6,
    R.drawable.ilustracion7 to R.string.ilustracion7,
    R.drawable.ilustracion8 to R.string.ilustracion8,
    R.drawable.ilustracion9 to R.string.ilustracion9,
    R.drawable.ilustracion10 to R.string.ilustracion10,
).map { DrawableStringPair(it.first, it.second) }
private val cocineros = listOf(

    R.drawable.arguiyano to R.string.arguiyano,
    R.drawable.eva to R.string.eva,
    R.drawable.danig to R.string.danig,
    R.drawable.elenaarzak to R.string.elenaarzak,
    R.drawable.najat to R.string.najat
).map { DrawableStringPair(it.first, it.second) }

// LISTA ICONOS (NO SE USA AL FINAL)
private val iconos = listOf(

    R.drawable.ic1 to R.string.ic1,
    R.drawable.ic2 to R.string.ic2,
    R.drawable.ic3 to R.string.ic3
).map { DrawableStringPair(it.first, it.second) }
// LISTA FOTOS USUARIO (NO SE USA AL FINAL)
private val usuariosImagen = listOf(

    R.drawable.us1 to R.string.us1,
    R.drawable.us2 to R.string.us2,
).map { DrawableStringPair(it.first, it.second) }

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun seccionPrincipalPreview() {
    Practica_04Theme {
        seccionPrincipal(R.string.ilustracion1){
            platosDestacadosRow()
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun pantallaAPPPreview() {
    Practica_04Theme { pantallaAPP() }
}
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
// PREVIEW TITULO ILUSTRACIONES
@Preview(showBackground = true)
@Composable
fun tituloIlustracionesPreview(){
    tituloIlustraciones()
}
// PREVIEW GRID DE ILUSTRACIONES
@Preview(showBackground = true)
@Composable
fun ilustracionesGridPreview(){
    ilustracionesGrid()
}

// PREVIEW BOTONERA ICONOS
@Preview(showBackground = true)
@Composable
fun botoneraIconosPreview(){
    botoneraIconos()
}
// PREVIEW RAIL BOTONERA ICONOS
@Preview(showBackground = true)
@Composable
fun botoneraIconosRailPreview(){
    botoneraIconosRail()
}

 */