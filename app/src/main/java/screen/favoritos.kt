package screen
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dam.practica_04.R
import com.dam.practica_04.ui.theme.Practica_04Theme
import navegacion.rutasNavegacion
@Composable
fun pantallaFavoritos(navController: NavController){
    principalAPP2(navController)
}


// AQUI HAY QUE METER LA TASKLIST DE FAVORITOS
@Composable
fun principalAPP2(navController: NavController){
   // when(windowSize.widthSizeClass){
      //  WindowWidthSizeClass.Compact ->{
            botoneraIconos2(navController)
        }
        //WindowWidthSizeClass.Medium ->{
         //   botonera2(navController = rememberNavController())
      //  }
    //}
//}
// SECCION RANURA PRINCIPAL
@Composable
fun seccionPrincipal2(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier){
        Text(
            stringResource(title),
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
// AQUI HAY QUE METER LA TASKLIST CON IMAGENES
@Composable
fun pantallaAPP2(modifier: Modifier= Modifier){
    seccionPrincipal2(title = R.string.favoritos) { // CAMBIAR TITULO <---------------------------
    }
        Surface {
            Text(text = "Prueba")
        }
}

// ICONOS BARRA NAVEGACION
@Composable
fun barraNavIconos2(navController: NavController) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.secondary) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(route = rutasNavegacion.ventanaInicio.ruta) },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label= { Text(text= stringResource(R.string.ic1)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(route = rutasNavegacion.ventanaUsuario.ruta) },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label= { Text(text= stringResource(R.string.ic2)) }
        )
        // boton favoritos

        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate(route = rutasNavegacion.ventanaFavoritos.ruta) },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
            label= { Text(text= stringResource(R.string.ic3)) }
        )
    }
}

// BOTONERA ICONOS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun botoneraIconos2(navController: NavController) {
    Practica_04Theme {
        Scaffold(
            bottomBar = { barraNavIconos2(navController)}
        ) {
                padding -> pantallaAPP2(Modifier.padding(padding))
        }
    }

}

// RAIL PARA ICONOS VERTICAL/HORIZONTAL NAVEGACION
@Composable
fun botoneraIconosRail2(navController: NavController) {
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
                onClick = { navController.navigate(route = rutasNavegacion.ventanaInicio.ruta)},
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
            )
            NavigationRailItem(
                label = { Text(stringResource(R.string.ic2)) },
                selected = true,
                onClick = { navController.navigate(route = rutasNavegacion.ventanaUsuario.ruta) },
                icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) }
            )
            NavigationRailItem(
                label = { Text(stringResource(R.string.ic3)) },
                selected = false,
                onClick = { navController.navigate(route = rutasNavegacion.ventanaFavoritos.ruta) },
                icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) }
            )
        }
    }
}
// BOTONERA COMPLETA
@Composable
fun botonera2(navController: NavController){
    Practica_04Theme{
        Surface(color= MaterialTheme.colorScheme.secondary) {
            Row{
                botoneraIconosRail2(navController)
                pantallaAPP2(Modifier)
            }
        }
    }
}