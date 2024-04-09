class Registrar {
    fun registrar():Usuario {
        println("Registro de usuario:")
        print("Email: ")
        val email = readLine()!!
        print("Nombre: ")
        val nombre = readLine()!! // controlar que meta de la a a la z
        print("Apellidos: ")
        val apellidos = readLine()!! // separar en dos variables que juntare al crar el usuario
        print("Edad: ")
        val edad = readLine()?.toIntOrNull() ?: 0
        print("Clave de acceso: ")
        val claveAcceso = readLine()!!

        val usuario = Usuario(email, nombre, apellidos, edad, claveAcceso)
        return usuario
    }
}