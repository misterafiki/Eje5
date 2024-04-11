import AccesoDatos.Implementacion
import Presentacion.Usuario
class GestionarBaseDatos {

    private var listaUsuarios=ArrayList<Usuario>()
    init {
        listaUsuarios=leerUsuarios()
    }

    fun registrar(usuario:Usuario) {
        //var usuarios=leerUsuarios()
        println("Presentacion.Usuario añadido....")
        guardarUsuario(usuario)
    }
    fun mostrarTodas() {
       listaUsuarios = leerUsuarios()
        if (listaUsuarios.isNotEmpty()) {
            println("Listado de Usuarios:")
            var index = 0
            for (usuario in listaUsuarios) {
                println("${index}. : nombre${usuario.nombre}  ${usuario.apellido}, email: ${usuario.email}, edad: ${usuario.edad}")
                index++
            }
        } else {
            println("No hay usuarios para mostrar.")
        }
    }
    fun borrarUsuario(email:String){
        Implementacion().deleteUsuario(email)
    }
    fun buscarUsuario(email: String): Usuario? {
        var us: Usuario? = null
       /* listaUsuarios = leerUsuarios()
        for (usuario in listaUsuarios) {
            if (email == usuario.email) {
                us = usuario
            }
        }

        */
        us = Implementacion().getUsuarioByEmail(email)
        return us

    }
    private fun guardarUsuario(usuario:Usuario) {
       Implementacion().insertUsuario(usuario)

    }
    private fun leerUsuarios(): ArrayList<Usuario> {
        var usuarios = arrayListOf<Usuario>()
                usuarios=Implementacion().getAllUsuarios()
        return usuarios
    }

}