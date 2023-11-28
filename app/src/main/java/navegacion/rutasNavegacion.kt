package navegacion
// sealed class para definir rutas, como parametro paso un String
sealed class rutasNavegacion(val ruta: String){
    object ventanaInicio: rutasNavegacion("ventanaInicio")
    object ventanaFavoritos: rutasNavegacion("ventanaFavoritos")
    object ventanaUsuario: rutasNavegacion("ventanaUsuario")
}
