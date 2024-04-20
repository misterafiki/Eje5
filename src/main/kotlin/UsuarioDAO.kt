class UsuarioDAO {
    private val conexion=ConexionBBDD()

    fun buscarUsuario(email:String):Usuario?{

        conexion.conectar()
        var consulta= "SELECT * FROM USUARIO WHERE EMAIL = ?"
        var ps= conexion.getPreparedStatement(consulta)
        ps?.setString(1, email)
        val rs = ps?.executeQuery()
        var usuario: Usuario? = null
        if (rs?.next() == true) {
            usuario = Usuario(
                rs.getString("EMAIL"),
                rs.getString("NOMBRE"),
                rs.getString("APELLIDOS"),
                rs.getInt("EDAD"),
                rs.getString("PASS"),
                rs.getBoolean("ADMIN"),
                rs.getBoolean("ESTANDAR")
            )
        }
        return usuario
    }
    fun comprobar(usuario:Usuario?, pass:String):Boolean{
        var passCorrecta=false
        if (usuario?.pass==pass){
            passCorrecta=true
        }
        return passCorrecta
    }

    fun registrar(user:Usuario){
        conexion.conectar()
        var insert="INSERT INTO USUARIO(EMAIL, NOMBRE, APELLIDOS, EDAD, PASS, ADMIN, ESTANDAR) VALUES (?,?,?,?,?,?,?)"
        var ps=conexion.getPreparedStatement(insert)
        ps?.setString(1,user.email)
        ps?.setString(2,user.apellido)
        ps?.setInt(3,user.edad)
        ps?.setString(4,user.pass)
        ps?.setBoolean(5,user.esAdmin)
        ps?.setBoolean(6,user.esEstandar)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
    }
    fun leerTodos():ArrayList<Usuario>{
        conexion.conectar()
        var consulta="SELECT * FROM USUARIO"
        var st=conexion.getStatement()
        var rs=st?.executeQuery(consulta)
        var listaUsers=ArrayList<Usuario>()
        while (rs?.next() == true) {
            listaUsers.add(Usuario(rs.getString("EMAIL"),rs.getString("NOMBRE"),rs.getString("APELLIDOS"),rs.getInt("EDAD"),rs.getString("PASS"),rs.getBoolean("ADMIN"),rs.getBoolean("ESTANDAR")))
        }

        st?.close()
        conexion.desconectar()
        return listaUsers
    }
    fun mostrarTodas(){
        var listaUsers=leerTodos()
        for (user in listaUsers){
            println(user)
        }
    }
    fun borrarUsuario(email: String):Boolean{
        conexion.conectar()
        var borrado=false
        var usuario=buscarUsuario(email)
        if (usuario!=null){
            var consulta="DELETE FROM USUARIO WHERE EMAIL = ?"
            var ps= conexion.getPreparedStatement(consulta)
            ps?.setString(1,usuario.email)
            val result =ps?.executeUpdate()
            ps?.close()
            if (result==1){
                borrado=true
            }
            conexion.desconectar()

        }


        return borrado
    }





}