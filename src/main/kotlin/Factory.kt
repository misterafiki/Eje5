class Factory {

    fun menuPrincipal() {
        println("Bienvenido al sistema:")
        println("1.- Login")
        println("2.- Registrar")
        println("3.- Salir")

        when (val opcion = readLine()?.toIntOrNull()) {
            1 -> login()
            2 -> registrar()
            3 -> println("¡Hasta luego!")
            else -> {
                println("Opción inválida. Por favor, seleccione una opción válida.")
                menuPrincipal()
            }
        }
    }





    fun menuAdmin() {
        println("Menú de administrador:")
        println("1.- Añadir usuario")
        println("2.- Mostrar usuarios")
        println("3.- Buscar usuario por email")
        println("4.- Borrar usuario")
        println("5.- Modificar usuario")
        println("6.- Cambiar permisos de usuario")
        println("7.- Salir")

        when (val opcion = readLine()?.toIntOrNull()) {
            1 -> GestionarFicheros().añadirUsuario()
            2 -> mostrarUsuarios()
            3 -> buscarUsuarioPorEmail()
            4 -> borrarUsuario()
            5 -> modificarUsuario()
            6 -> cambiarPermisos()
            7 -> menuPrincipal()
            else -> {
                println("Opción inválida. Por favor, seleccione una opción válida.")
                menuAdmin()
            }
        }
    }
}