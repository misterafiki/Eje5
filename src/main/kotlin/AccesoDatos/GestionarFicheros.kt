package AccesoDatos

import Usuario
import java.io.*
import java.util.*
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
        println("Usuario añadido....")
        guardarUsuarios(listaUsuarios)
//        val fileOutputStream = FileOutputStream(archivo,true)
//        val objectOutputStream = ObjectOutputStream(fileOutputStream)
//        objectOutputStream.writeObject(usuarios)
//        objectOutputStream.close()
    }

    fun mostrarTodas() {
        val usuarios = leerUsuarios()
        if (usuarios.isNotEmpty()) {
            println("Listado de Usuarios:")
            var index = 0
            for (usuario in usuarios) {
                println("${index}. ${usuario.nombre}  ${usuario.apellido} (${usuario.email}), ${usuario.edad}")
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
    private fun guardarUsuarios(usuarios: List<Usuario>) {
        val fileOutputStream = FileOutputStream(archivo)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)
        for (usuario in usuarios) {
            objectOutputStream.writeObject(usuario)
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
    /*fun leerUsuarios(): List<Usuario> {
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
    }*/
}
