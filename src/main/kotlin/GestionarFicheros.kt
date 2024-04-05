import java.io.*
import java.util.*
import kotlin.collections.ArrayList

class GestionarFicheros {
var archivo="usuarios.dat"
    fun registrar(usuario: Usuario){
        var usuarios=leerUsuarios()
        usuarios.add(usuario)
        val fileOutputStream = FileOutputStream(archivo,true)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)
        objectOutputStream.writeObject(usuarios)
        objectOutputStream.close()
    }

    fun leerUsuarios():ArrayList<Usuario> {
        val usuarios = arrayListOf<Usuario>()
        val archivo = File(archivo)
        if (archivo.exists()) {
            var objectInputStream: ObjectInputStream? = null
            try {
                objectInputStream = ObjectInputStream(FileInputStream(archivo))
                while (true) {
                    val user = objectInputStream.readObject() as Usuario
                    usuarios.add(user)
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
