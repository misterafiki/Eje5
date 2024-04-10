package conexionBBDD
import java.sql.*
class ConexionBD {
    private val url = "jdbc:mysql://localhost/usuarios"
    private var conn: Connection? = null
    private val user = "root"
    private val pass = ""
    fun conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(url, user, pass)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
    fun desconectar() {
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
    fun getStatement(): Statement? {
        return conn?.createStatement()
    }
    fun getPreparedStatement(sql: String): PreparedStatement? {
        return conn?.prepareStatement(sql)
    }
}