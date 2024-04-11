package conexionBBDD

import Presentacion.Usuario

interface InterfacesUsuarios {
    fun getUsuarioByEmail(email: String): Usuario?
    fun getAllUsuarios(): ArrayList<Usuario>
    fun insertUsuario(usaurio: Usuario): Boolean
    fun deleteUsuario(codigo: String): Boolean
    fun updateUsuario(usaurio: Usuario): Boolean
    /*
    fun updateNombre(usaurio: Usuario): Boolean
    fun updateApellido(usaurio: Usuario): Boolean
    fun updatePass(usaurio: Usuario): Boolean
    fun updateRol1(usaurio: Usuario): Boolean
    fun updateRol2(usaurio: Usuario): Boolean
    fun updateEmail(usaurio: Usuario): Boolean
    fun updateedad(usaurio: Usuario): Boolean

     */

}
