class UsuarioDAOFicheros {
    val g=GestionarFicheros()
    fun comprobar(usuario:Usuario?, pass:String):Boolean{
        var passCorrecta=false
        if (usuario?.pass==pass){
            passCorrecta=true
        }
        return passCorrecta
    }
    fun registrar(usuario: Usuario){
        var listaUsuarios=g.leerUsuarios()
        listaUsuarios.add(usuario)
        println("Usuario añadido....")
        g.guardarUsuarios(listaUsuarios)

    }
    fun mostrarTodas() {
        val usuarios = g.leerUsuarios()
        if (usuarios.isNotEmpty()) {
            println("Listado de Usuarios:")
            var index = 0
            for (usuario in usuarios) {
                println("$index $usuario")
                index++
            }
        } else {
            println("No hay usuarios para mostrar.")
        }
    }
    fun buscarUsuario(email:String):Usuario?{
        var us:Usuario?=null
        var listaUsuarios=g.leerUsuarios()
        for (usuario in listaUsuarios){
            if (email==usuario.email){
                us=usuario
            }
        }
        return us
    }
    fun borrarUsuario(email:String):Boolean{

        var listaUsuarios = g.leerUsuarios()
        var borrado=false
        for (i in 0 ..<listaUsuarios.size) {
            if (email == listaUsuarios[i].email) {
                listaUsuarios.remove(listaUsuarios[i])
                borrado=true
            }
        }

        g.guardarUsuarios(listaUsuarios)
        return borrado
    }
    fun modificarUsuario(usuario: Usuario,modificacion:Int,valor:String):Boolean{
        var listaUs=g.leerUsuarios()
        var correcto=false
        for (i in 0..<listaUs.size){
            if (listaUs[i].email==usuario.email){
                if (modificacion==1) {
                    modificarNombre(listaUs[i],valor)
                }else if (modificacion==2){
                    modificarApellido(listaUs[i],valor)
                }else if (modificacion==3){
                    modficarEdad(listaUs[i],valor)
                }
                correcto=true
            }
        }
        g.guardarUsuarios(listaUs)
        return correcto
    }
    fun modificarNombre(usuario: Usuario,nombre:String):Usuario{
        usuario.nombre=nombre
        return usuario
    }
    fun modificarApellido(usuario: Usuario,apellidos:String):Usuario{
        usuario.apellido=apellidos
        return usuario
    }
    fun modficarEdad(usuario: Usuario,edad:String):Usuario{
        usuario.edad=edad.toInt()
        return usuario
    }
}