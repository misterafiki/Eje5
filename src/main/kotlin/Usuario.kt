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


    override fun toString(): String {
        return "Usuario(email='$email', nombre='$nombre', apellido='$apellido', edad=$edad, pass='$pass', esAdmin=$esAdmin, esEstandar=$esEstandar)"
    }

}
