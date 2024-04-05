class MenuAdmin {

   /* fun menu(){
        var seguir: Boolean = true
        while (seguir) {
            println("\nElige una opción:")
            println("1. Añadir usuario.")
            println("2. Mostrar Usuarios.")
            println("3. Borrar usuario.")
            println("4. Borrar usaurio por email.")
            println("5. Modificar usuario.")
            println("6. Cambiar permisoa de usuario.")
            println("7. Salir.")

            when (readLine()?.toIntOrNull()) {
                1 -> anadirUsuario()
                2 -> mostrarUsuarios()
                3 -> borarUsuario()
                4 -> borrarEmail()
                5 -> modificarUsuario()
                6-> CambiarPermisos()
                7->{
                    println("Fin")
                    seguir = false
                }
                else -> println("Opción no válida, por favor elige un número del 1 al 4.")
            }
        }
    }*/

    fun anadirUsuario() {
        GestionarFicheros().registrar()
    }

    fun mostrarUsuarios() {
        GestionarFicheros().mostrartodo()
    }

    fun borarUsuario() {
        GestionarFicheros().BorraUsuario()
    }

    fun BuscarEmail() {
        GestionarFicheros().mostrarUsuarioEmail()
    }
}
