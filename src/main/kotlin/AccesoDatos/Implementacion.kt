package AccesoDatos

import Usuario
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
        var usuario: InterfacesUsuarios? = null
        if (rs?.next() == true) {
            usuario = Usuario(rs.getString("email"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"))
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
        val usuarios = mutableListOf<Usuario>()
        while (rs?.next() == true) {
            val categoria = Usuario(rs.getInt("email"), rs.getString("nombre"))
            usuarios.add(categoria)
        }
        st?.close()
        conexion.desconectar()
        return usuarios
    }

    override fun insertUsuario(email: Usuario): Boolean {
        conexion.conectar()
        val query = "INSERT INTO usuarios (email, nombre) VALUES (?, ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, categoria.codigo)
        ps?.setString(2, categoria.nombre)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateusuario(email: Usuario): Boolean {
        conexion.conectar()
        val query = "UPDATE usuarios SET nombre = ? WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, categoria.nombre)
        ps?.setInt(2, categoria.codigo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteUsuario(codigo: Int): Boolean {
        conexion.conectar()
        val query = "DELETE FROM usuarios WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, codigo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}

