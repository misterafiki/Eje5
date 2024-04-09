class ComprobarLogin {

    fun comprobar(usuario:Usuario?, pass:String):Boolean{
        var passCorrecta=false
        if (usuario?.pass==pass){
            passCorrecta=true
        }
        return passCorrecta
    }
    fun buscarUsuario(email:String):Usuario?{
        var us:Usuario?=null
        var g=GestionarFicheros()               // llevar a GestionarFicheros
        var listaUsuarios=g.leerUsuarios()
        for (usuario in listaUsuarios){
            if (email==usuario.email){
                us=usuario
            }
        }
        return us
    }


}