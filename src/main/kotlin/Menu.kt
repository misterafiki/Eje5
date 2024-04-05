class Menu {

    companion object {


        fun menuPrincipal() {
            println("Bienvenido al sistema:")
            println("1.- Login")
            println("2.- Registrar")
            println("3.- Salir")
            val USER=Usuario()
            val GESTION =GestionarFicheros()

            when (val opcion = readLine()?.toIntOrNull()) {
                1 -> USER.login()
                2 -> GESTION.registrar()
                3 -> Menu.salida()
                else -> {
                    println("Opción inválida. Por favor, seleccione una opción válida.")
                    menuPrincipal()
                }
            }
        }


        fun menuAdmin() {
            val USER=Usuario()
            val GESTION =GestionarFicheros()
            println("Menú de administrador:")
            println("1.- Añadir usuario")
            println("2.- Mostrar usuarios")
            println("3.- Buscar usuario por email")
            println("4.- Borrar usuario")
            println("5.- Modificar usuario")
            println("6.- Cambiar permisos de usuario")
            println("7.- Salir")

            //2 y 3 van a acceder al arrayList de usuarios que se encuentra en Usuario
            when (val opcion = readLine()?.toIntOrNull()) {
                1 -> GESTION.registrarPorAdmin()
                2 -> USER.mostrarUsuarios()
                3 -> USER.mostrarUsuarioPorEmail()
                4 -> GESTION.borrarUsuario()
                5 -> GESTION.modificarUsuario()
                6 -> GESTION.cambiarPermisos()
                7 -> menuPrincipal()
                else -> {
                    println("Opción inválida. Por favor, seleccione una opción válida.")
                    menuAdmin()
                }
            }
        }


            fun salida(): String {
                return "¡Hasta luego!"
            }

    }

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