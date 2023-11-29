package navegacion

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dam.practica_04.MainActivity
import screen.pantallaAPP
import screen.pantallaAPP2
import screen.pantallaFavoritos
import screen.pantallaInicio
import screen.pantallaUsuario
import screen.principalAPP
import screen.principalAPP2

// para la navegacion entre pantallas
@Composable
fun navegacion(){
    val navController= rememberNavController()
    NavHost(navController= navController, startDestination= rutasNavegacion.ventanaInicio.ruta){
        // llama a pantallaAPP1 donde esta toda la pantalla de inicio
        composable(route = rutasNavegacion.ventanaInicio.ruta){
            pantallaInicio(navController)
                //principalAPP(calculateWindowSizeClass(activity = ))
        }
        // llama a pantallaAPP2 donde esta favoritos
        composable(route= rutasNavegacion.ventanaFavoritos.ruta){
            pantallaFavoritos(navController)
        }
        composable(route= rutasNavegacion.ventanaUsuario.ruta){
            pantallaUsuario(navController)
        }
    }
}



