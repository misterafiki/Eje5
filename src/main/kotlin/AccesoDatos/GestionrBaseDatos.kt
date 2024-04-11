class GestionarBaseDatos{

    fun registrar(usuario: Usuario){
        //var usuarios=leerUsuarios()
        println("Presentacion.Usuario añadido....")
        guardarUsuario()
    }
    fun mostrarTodas() {
        val usuarios = leerUsuarios()
        if (usuarios.isNotEmpty()) {
            println("Listado de Usuarios:")
            var index = 0
            for (usuario in usuarios) {
                println("${index}. : nombre${usuario.nombre}  ${usuario.apellido}, email: ${usuario.email}, edad: ${usuario.edad}")
                index++
            }
        } else {
            println("No hay usuarios para mostrar.")
        }
    }
    fun buscarUsuario(email:String): Usuario?{
        var us: Usuario?=null
        listaUsuarios=leerUsuarios()
        for (usuario in listaUsuarios){
            if (email==usuario.email){
                us=usuario
            }
        }
        return us
    }
    private fun guardarUsuarios(usuarios:Usuario){

    }
    private fun leerUsuarios(): ArrayList<Usuario> {
        val usuarios = arrayListOf<Usuario>()
        
        if (archivo.exists()) {
            var objectInputStream: ObjectInputStream? = null
            retun usuarios 
}