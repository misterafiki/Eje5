import Presentacion.Usuario
import java.io.*
import kotlin.collections.ArrayList

class GestionarFicheros {

    private val archivo= "usuario.dat"
    private var listaUsuarios=ArrayList<Usuario>()
    init {
        listaUsuarios=leerUsuarios()
    }

    fun registrar(usuario: Usuario){
        //var usuarios=leerUsuarios()
        listaUsuarios.add(usuario)
        println("Presentacion.Usuario añadido....")
        guardarUsuarios(listaUsuarios)
    }
    fun mostrarTodas() {
        val usuarios = leerUsuarios()
        if (usuarios.isNotEmpty()) {
            println("Listado de Usuarios:")
            var index = 0
            for (usuario in usuarios) {
                println("${index}. : nombre${usuario.nombre}  ${usuario.apellido}, email: ${usuario.email}, edad: ${usuario.edad}")
                index++
            }
        } else {
            println("No hay usuarios para mostrar.")
        }
    }
    fun buscarUsuario(email:String): Usuario?{
        var us: Usuario?=null
        listaUsuarios=leerUsuarios()
        for (usuario in listaUsuarios){
            if (email==usuario.email){
                us=usuario
            }
        }
        return us
    }
    private fun guardarUsuarios(usuarios: List<Usuario>) {
        val fileOutputStream = FileOutputStream(archivo)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)
        for (pelicula in usuarios) {
            objectOutputStream.writeObject(pelicula)
        }
        objectOutputStream.close()
    }
    private fun leerUsuarios(): ArrayList<Usuario> {
        val usuarios = arrayListOf<Usuario>()
        val archivo = File(archivo)
        if (archivo.exists()) {
            var objectInputStream: ObjectInputStream? = null
            try {
                objectInputStream = ObjectInputStream(FileInputStream(archivo))
//                println(listOf(objectInputStream).size)
                while (true) {
                    val usuario = objectInputStream.readObject() as Usuario
                    usuarios.add(usuario)
                }
            } catch (e: EOFException) {
                // Se alcanzó el final del archivo
            } finally {
                objectInputStream?.close()
            }
        }
        return usuarios
    }
}
