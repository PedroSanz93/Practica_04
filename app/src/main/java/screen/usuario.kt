package screen

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dam.practica_04.R
import com.dam.practica_04.ui.theme.Practica_04Theme
import navegacion.rutasNavegacion

@Composable
fun pantallaUsuario(navController: NavController) {
    principalAPP3(navController)
}


// AQUI HAY QUE METER LA TASKLIST DE FAVORITOS
@Composable
fun principalAPP3(navController: NavController) {
    // when(windowSize.widthSizeClass){
    //  WindowWidthSizeClass.Compact ->{
    botoneraIconos3(navController)
}

//WindowWidthSizeClass.Medium ->{
//   botonera2(navController = rememberNavController())
//  }
//}
//}
// SECCION RANURA PRINCIPAL
@Composable
fun seccionPrincipal3(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

// AQUI HAY QUE HACER UN FORMULARIO CON LA BARRA DE BUSCARDOR DE INICIO QUE TENGA USUARIO Y CONTRASEÑA
@Composable
fun pantallaAPP3(modifier: Modifier = Modifier) {
    seccionPrincipal2(title = R.string.usuario) {
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {
        // Para el fondo
        Image(
            painter = painterResource(id = R.drawable.fondopantalla),
            contentScale = ContentScale.FillBounds,
            contentDescription = "fondo",
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier.verticalScroll(rememberScrollState())) {
            formulario()
        }
    }
}
// formulario
@Composable
fun formulario() {
    // variables mutables que guardan el valor del texto que se introduce en usuario y contraseña
    var texto by remember { mutableStateOf("") }
    var texto2 by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        // colunm donde monto usuario y contraseña para emular un registro de usuario y contraseña
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // usuario
            Text(
                text = "Usuario",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextField(
                // value guarda el valor de la variable texto
                value = texto,
                // el nuevo valor sera lo que se introduzca desde el teclado en texto
                onValueChange = { nuevoValor ->
                    texto = nuevoValor
                },
                modifier = Modifier.fillMaxWidth(),
                // texto por defecto que viene escrito en textfield
                placeholder = {
                    Text(text = "Escribe aquí...")
                }
            )
            // separacion
            Spacer(modifier = Modifier.height(16.dp))
            // contraseña
            Text(
                text = "Contraseña",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextField(
                // value guarda el valor de la variable texto
                value = texto2,
                // el nuevo valor sera lo que se introduzca desde el teclado en texto2
                onValueChange = { nuevoValor ->
                    texto2 = nuevoValor
                },
                modifier = Modifier.fillMaxWidth(),
                // texto por defecto que viene escrito en textfield
                placeholder = {
                    Text(text = "Escribe aquí...")
                }
            )
        }
    }
}


// ICONOS BARRA NAVEGACION
@Composable
fun barraNavIconos3(navController: NavController) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.secondary) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(route = rutasNavegacion.ventanaInicio.ruta) },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label = { Text(text = stringResource(R.string.ic1)) }
        )
        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate(route = rutasNavegacion.ventanaUsuario.ruta) },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(text = stringResource(R.string.ic2)) }
        )
        // boton favoritos

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(route = rutasNavegacion.ventanaFavoritos.ruta) },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
            label = { Text(text = stringResource(R.string.ic3)) }
        )
    }
}

// BOTONERA ICONOS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun botoneraIconos3(navController: NavController) {
    Practica_04Theme {
        Scaffold(
            bottomBar = { barraNavIconos3(navController) }
        ) { padding ->
            pantallaAPP3(Modifier.padding(padding))
        }
    }
}

// RAIL PARA ICONOS VERTICAL/HORIZONTAL NAVEGACION
@Composable
fun botoneraIconosRail3(navController: NavController) {
    NavigationRail(
        //modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Column(
            //modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            NavigationRailItem(
                label = { Text(stringResource(R.string.ic1)) },
                selected = false,
                onClick = { navController.navigate(route = rutasNavegacion.ventanaInicio.ruta) },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
            )
            NavigationRailItem(
                label = { Text(stringResource(R.string.ic2)) },
                selected = true,
                onClick = { navController.navigate(route = rutasNavegacion.ventanaUsuario.ruta) },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                }
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
fun botonera3(navController: NavController) {
    Practica_04Theme {
        Surface(color = MaterialTheme.colorScheme.secondary) {
            Row {
                botoneraIconosRail3(navController)
                pantallaAPP3(Modifier)
            }
        }
    }
}