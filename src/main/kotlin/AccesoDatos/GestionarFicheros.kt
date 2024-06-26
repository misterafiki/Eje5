package AccesoDatos

import Usuario
import java.io.*
import java.util.*
import kotlin.collections.ArrayList

class GestionarFicheros {

    //private val archivo= "usuario.dat"
    private var listaUsuarios=ArrayList<Usuario>()
    init {
        listaUsuarios=leerUsuarios()
    }

    fun registrar(usuario: Usuario){
        println("Usuario añadido....")
        guardarUsuarios(usuario)
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
    fun borrarUusario(email: String) {
        val listaUsuarios = leerUsuarios()
        /*val emailBuscado = email.lowercase(Locale.getDefault())
        var encontrada = false
        val listaUsuariosBorrar = arrayListOf<Usuario>()
        for (usuario in listaUsuarios) {
            if (usuario.email.toLowerCase().startsWith(emailBuscado)) {
                encontrada = true
            } else {
                listaUsuariosBorrar.add(usuario)
            }
        }*/
        val listaUsuariosBorrar = arrayListOf<Usuario>()
        listaUsuariosBorrar.add(usuario)
        if (encontrada) {
            for (usuarioParaBorrar in listaUsuariosBorrar) {
                listaUsuarios.remove(usuarioParaBorrar)
            }
            guardarUsuarios(listaUsuarios)
            println("Usuario borrado correctamente.")

        } else {
            println("No se encontró ningun usuario con ese email.")
        }
    }
    fun buscarUsuario(email:String):Usuario?{
        var us:Usuario?=null
        listaUsuarios=leerUsuarios()
        for (usuario in listaUsuarios){
            if (email==usuario.email){
                us=usuario
            }
        }
        return us
    }
    private fun guardarUsuarios(usuario:Usuario) {
        Implementacion().insertUsuario(usuario)
    }
    /*private fun guardarUsuarios(usuarios: List<Usuario>) {
        val fileOutputStream = FileOutputStream(archivo)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)
        for (usuario in usuarios) {
            objectOutputStream.writeObject(usuario)
        }
        objectOutputStream.close()
    }

     */
    /*private fun leerUsuarios(): ArrayList<Usuario> {
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

     */

    private fun leerUsuarios(): ArrayList<Usuario> {
        var usuarios = ArrayList<Usuario>()
            usuarios=Implementacion().getAllUsuarios()
        return usuarios
    }
}
