import java.io.Serializable

data class Usuario (var email:String,
                 var nombre:String,
                 var apellido:String,
                 var edad:Int,
                 var pass:String,
                 var esAdmin:Boolean=false,
                 var esEstandar:Boolean=true):Serializable {


   /* lateinit var email:String
    lateinit var nombre:String
    lateinit var apellido:String
    var edad:Int = 0
    lateinit var pass:String
    var esAdmin:Boolean=false
    var esEstandar:Boolean=true*/

   /* constructor(){}
    constructor(email: String, nombre: String, apellido: String, edad: Int, pass: String) {
        this.email = email
        this.nombre = nombre
        this.apellido = apellido
        this.edad = edad
        this.pass = pass
    }*/

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
   /* fun login() {
        println("Inicio de sesión:")
        print("Email: ")
        val email = readLine()!!
        print("Clave de acceso: ")
        val claveAcceso = readLine()!!

        val usuarios = GestionarFicheros().leerUsuarios()
        val usuario = usuarios.find { it.email == email && it.pass == claveAcceso }

        if (usuario != null) {
            println("Inicio de sesión exitoso.")
            if (usuario.esAdmin) {
                menuAdmin()
            } else {
                // Aquí se podría llamar a la función para jugar el juego
                println("Bienvenido, ${usuario.nombre}.")
            }
        } else {
            println("Email o contraseña incorrectos.")
            menuPrincipal()
        }
    }*/

    fun adivinarNumero() {

        println("¡Bienvenido a la aplicación ADIVINA EL NÚMERO!")
        println("El juego consiste en adivinar un número secreto comprendido entre el número 1 y el número 20")

        var cantidadPartidasJugadas = 0
        var cantidadPartidasGanadas = 0
        var continuarJugando = true

        while (continuarJugando) {

            val turnoMaximo = 10
            var turnoMinimo = 0

            while (turnoMinimo < turnoMaximo) {
                turnoMinimo++
                val numeroSecreto: Int = (1..20).random()
                println("Dime tu número y te diré si es el número secreto")
                val numeroSeleccionado: Int = readln().toInt()

                if (numeroSeleccionado == numeroSecreto && turnoMinimo == turnoMaximo) {
                    println("¡ENHORABUENA! Has adivinado el número secreto, que era el número $numeroSecreto")
                    cantidadPartidasGanadas++
                    turnoMinimo = 10

                } else {
                    println("Lo siento ese no es el número secreto")
                }

                if (turnoMinimo == turnoMaximo && numeroSeleccionado != numeroSecreto) {
                    println("Lo siento, se han agotado los turnos, el número secreto es el número $numeroSecreto")
                }

                if (turnoMinimo == turnoMaximo) {
                    cantidadPartidasJugadas++
                }
            }
            println("¿Quieres seguir jugando? (s/n)")
            val respuesta = readLine()!!.toLowerCase()
            if (respuesta != "s") {
                continuarJugando = false
            }
        }
        println("Cantidad de partidas jugadas: $cantidadPartidasJugadas")
        println("Cantidad de partidas ganadas: $cantidadPartidasGanadas")
        }

}