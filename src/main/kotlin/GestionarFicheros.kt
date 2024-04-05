import java.io.*
import java.util.*
class GestionarFicheros {

    val archivo= "archivo.txt"

    fun login(email:String,pass:String){
            val usuarios = leerFichero()
            val emailBuscado= email.lowercase()
            //val passBuscado=pass
            var encontrado= false
            for (i in usuarios){
                if (i.lowercase().startsWith(emailBuscado)){
                    var nuevai=i.split(",")
                    if (nuevai[3]==pass){
                        encontrado=true
                    }
                }
            }
            if (encontrado && Usuario().esEstandar && !Usuario().esAdmin) {
                println("Bienvenido ${Usuario().nombre}")
                Juego().adivinarNumero()
            } else if (encontrado && Usuario().esEstandar && Usuario().esAdmin){
                Menu.mostrarMenuEstandar()
                Menu.mostrarMenuAdmin()
            }else if (encontrado && !Usuario().esEstandar &&Usuario().esAdmin){
                Menu.mostrarMenuAdmin()
            }else println("email o contraseña incorrectos")

        }

    fun leerFichero(): List<String> {
            val usuarios = arrayListOf<String>()
            val archivo = File(archivo) //File te permite moverte por "explorador", si no existe, no arroja error, se guarda que no existe (JAVA devuelve un null)
            if (archivo.exists()) {
                var bufferedReader: BufferedReader? = null //trozo de memoria compartido/reservado con el programa
                try {
                    bufferedReader =
                        BufferedReader(FileReader(archivo)) //se abre el canal con el archivo para poder ir leyendo
                    var linea: String? = bufferedReader.readLine() //puede ser null
                    while (linea != null) {
                        usuarios.add(linea)
                        linea = bufferedReader.readLine()
                    }
                } finally {
                    bufferedReader?.close() //cerramos la comunicacion con el SO
                }
            }
            return usuarios
        }

    fun leerUsuarios(): List<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        File(archivo).forEachLine { linea ->
            val datos = linea.split(",")
            usuarios.add(
                Usuario(
                    datos[0],
                    datos[1],
                    datos[2],
                    datos[3].toInt(),
                    datos[4],
                    datos[5].toBoolean(),
                    datos[6].toBoolean()
                )
            )
        }
        return usuarios
    }
}
