fun main() {
    var seguir: Boolean = true
    while (seguir) {
        println("\nElige una opción:")
        println("1. Login")
        println("2. Registar")
        println("3. Salir")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                 var usuario=Usuario.login()
                 GestionarFicheros().login(usuario)
            }
            2 -> {
                var usuario=Usuario()
                usuario.registrar()

                }
            3 -> {
                println("Fin")
                seguir = false
            }
            else -> println("Opción no válida, por favor elige un número del 1 al 3.")
        }
    }

   // Factory().menuPrincipal()

}