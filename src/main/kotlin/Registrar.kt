class Registrar {
    fun registrar():Usuario {
        println("Registro de usuario:")
        print("Email: ")
        val email = readLine()!!
        print("Nombre: ")
        val nombre = readLine()!!
        print("Apellidos: ")
        val apellidos = readLine()!!
        print("Edad: ")
        val edad = readLine()?.toIntOrNull() ?: 0
        print("Clave de acceso: ")
        val claveAcceso = readLine()!!

        val usuario = Usuario(email, nombre, apellidos, edad, claveAcceso)
        return usuario
    }
}