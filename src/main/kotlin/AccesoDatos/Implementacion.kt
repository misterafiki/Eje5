package AccesoDatos

import Presentacion.Usuario
import conexionBBDD.InterfacesUsuarios
import conexionBBDD.ConexionBD

class Implementacion : InterfacesUsuarios {
    private val conexion = ConexionBD()

    override fun getUsuarioByEmail(email: Int): Usuario? {
        conexion.conectar()
        val query = "SELECT * FROM usuarios WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, email)
        val rs = ps?.executeQuery()
        var usuario: Usuario? = null
        if (rs?.next() == true) {
            usuario = Usuario(rs.getString("email"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getInt("edad"),rs.getString("pass"),
                rs.getBoolean("esAdmin"),rs.getBoolean("esEstandar"))
            }
        ps?.close()
        conexion.desconectar()
        return usuario
    }

    override fun getAllUsuarios(): ArrayList<Usuario> {
        conexion.conectar()
        val query = "SELECT * FROM usuarios"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val usuarios = ArrayList<Usuario>()
        while (rs?.next() == true) {
            val usuario = Usuario(rs.getString("email"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getInt("edad"),rs.getString("pass"),
                rs.getBoolean("esAdmin"),rs.getBoolean("esEstandar"))
            usuarios.add(usuario)
        }
        st?.close()
        conexion.desconectar()
        return usuarios
    }
    /**Falta por terminar el insert, delete y update configuracion correspondiente al Gestion fichero **/
    override fun insertUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val query = "INSERT INTO usuarios (email, nombre, apellidos, edad, pass, esAdmin, esEstandar) VALUES (?, ?, ?, ?, ?, ?, ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.email)
        ps?.setString(2, usuario.nombre)
        ps?.setString(3, usuario.apellido)
        ps?.setInt(4, usuario.edad)
        ps?.setString(5, usuario.pass)
        ps?.setBoolean(6, usuario.esAdmin)
        ps?.setBoolean(7, usuario.esEstandar)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateusuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val query = "UPDATE usuarios SET email = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, usuario.nombre)
        ps?.setString(2, usuario.email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteUsuario(email: String): Boolean {
        conexion.conectar()
        val query = "DELETE FROM usuarios WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, email)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}

