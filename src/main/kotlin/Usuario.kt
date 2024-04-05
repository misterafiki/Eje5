class Usuario   /*(var email:String,
                 var nombre:String,
                 var apellido:String,
                 var edad:Int,
                 var pass:String,
                 var esAdmin:Boolean=false,
                 var esEstandar:Boolean=true)*/ {


    lateinit var email:String
    lateinit var nombre:String
    lateinit var apellido:String
    var edad:Int = 0
    lateinit var pass:String
    var esAdmin:Boolean=false
    var esEstandar:Boolean=true

    constructor(){}
    constructor(email: String, nombre: String, apellido: String, edad: Int, pass: String) {
        this.email = email
        this.nombre = nombre
        this.apellido = apellido
        this.edad = edad
        this.pass = pass
    }

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
    fun login() {
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
    }

}