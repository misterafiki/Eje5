package Presentacion

class Login {
    fun login():ArrayList<String>{
        var datos=ArrayList<String>()
        println("Introduce tu email")
        datos.add(readln())
        println("escribe tu contraseña")
        datos.add(readln())
        return datos
    }
}