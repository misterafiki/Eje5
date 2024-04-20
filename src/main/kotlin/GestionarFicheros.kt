import java.io.*
import java.util.*
import kotlin.collections.ArrayList

class GestionarFicheros {

    private val archivo= "usuario.dat"

    fun guardarUsuarios(usuarios: List<Usuario>) {
        val fileOutputStream = FileOutputStream(archivo)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)
        for (pelicula in usuarios) {
            objectOutputStream.writeObject(pelicula)
        }
        objectOutputStream.close()
    }

    fun leerUsuarios(): ArrayList<Usuario> {
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
