package navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screen.pantallaAPP
import screen.pantallaAPP2

// para la navegacion entre pantallas
@Composable
fun navegacion(){
    val navController= rememberNavController()
    NavHost(navController= navController, startDestination= rutasNavegacion.ventanaInicio.ruta){
        // llama a pantallaAPP1 donde esta toda la pantalla de inicio
        composable(route = rutasNavegacion.ventanaInicio.ruta){
                pantallaAPP()
        }
        // llama a pantallaAPP2 donde esta favoritos
        composable(route= rutasNavegacion.ventanaFavoritos.ruta){
                pantallaAPP2()
        }
    }
}



