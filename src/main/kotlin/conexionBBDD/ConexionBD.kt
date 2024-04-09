package conexionBBDD
import java.sql.*
class ConexionBD {
    private val url = "jdbc:mysql://localhost/usuarios"
    private var conn: Connection? = null
    fun conectar() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")
            conn = DriverManager.getConnection(url)
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