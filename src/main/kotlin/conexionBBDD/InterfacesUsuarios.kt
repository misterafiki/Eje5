package conexionBBDD

import Presentacion.Usuario

interface InterfacesUsuarios {
    fun getUsuarioByEmail(email: Int): Usuario?
    fun getAllUsuarios(): ArrayList<Usuario>
    fun insertUsuario(usaurio: Usuario): Boolean
    fun updateusuario(usaurio: Usuario): Boolean
    fun deleteUsuario(codigo: String): Boolean

}
