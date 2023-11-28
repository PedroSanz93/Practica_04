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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dam.practica_04.R
import com.dam.practica_04.ui.theme.Practica_04Theme

// HAY QUE TOCAR LOS BOTONES DE NAVEGACION PARA QUE AL HACER CLICK EN PATALLA NOS TRAIGA AQUI
// AYUDA VIDEO    https://www.youtube.com/watch?v=eNuaMn4ukdo&list=PLNdFk2_brsRclwvl8ruCo_q36jVbXcCCx&index=5
@Composable
fun pantallaAPP2(){
    // AQUI HAY QUE METER LA TASKLIST DE FAVORITOS

}
@Composable
fun principalAPP2(windowSize: WindowSizeClass){
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

// ICONOS BARRA NAVEGACION
@Composable
fun barraNavIconos2(modifier: Modifier = Modifier) {
    NavigationBar(modifier= modifier, containerColor = MaterialTheme.colorScheme.secondary) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label= { Text(text= stringResource(R.string.ic1)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label= { Text(text= stringResource(R.string.ic2)) }
        )
        // boton favoritos

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
            label= { Text(text= stringResource(R.string.ic3)) }
        )
    }
}

// BOTONERA ICONOS
@Composable
fun botoneraIconos2() {
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
fun botoneraIconosRail2(modifier: Modifier = Modifier) {
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
fun botonera2(){
    Practica_04Theme{
        Surface(color= MaterialTheme.colorScheme.secondary) {
            Row{
                botoneraIconosRail()
                pantallaAPP()
            }
        }
    }
}