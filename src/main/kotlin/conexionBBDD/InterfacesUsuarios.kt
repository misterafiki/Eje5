package conexionBBDD

import Usuario

interface InterfacesUsuarios {
    fun getUsuarioByEmail(email: Int): Usuario?
    fun getAllUsuarios(): ArrayList<Usuario>
    fun insertUsuario(email: Usuario): Boolean
    fun updateusuario(email: Usuario): Boolean
    fun deleteUsuario(codigo: Int): Boolean

}
