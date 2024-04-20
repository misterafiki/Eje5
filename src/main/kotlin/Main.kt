fun main() {
   /*var usuarioAdmin=Usuario("admin@gmail.com","admin","***",10,"1234",true,true)
    */
    var menu=Menu()
   var controlador=UsuarioDAOFicheros()
    //var controlador=UsuarioDAO()
    var user:Usuario?
    var juego=Juego()
        var opcion= menu.menuPrincipal()
        var rolElegido:Int?
        when (opcion){
            1->{
                do {
                    var datos=menu.pedirDatosLogin()
                    user=controlador.buscarUsuario(datos[0])

                }while (user==null || !controlador.comprobar(user,datos[1]))
                if (user.esAdmin){
                    do {
                        rolElegido= menu.elegirRol()
                    }while (rolElegido==null)
                    if (rolElegido==1){

                        juego.adivinarNumero()
                    }else if (rolElegido==2){
                        do {
                            var opcionAdmin=menu.menuAdmin()
                            when(opcionAdmin){
                                1->{
                                    var datos=menu.pedirDatosRegistro()
                                    user=Usuario(datos[0],datos[1],datos[2],datos[3].toInt(),datos[4])
                                    controlador.registrar(user)
                                }
                                2->{controlador.mostrarTodas()}
                                3-> {
                                    var email = menu.pedirEmail()
                                    var user: Usuario? = controlador.buscarUsuario(email)
                                    if (user != null) {
                                        println(user)
                                    } else println("Usuario no encontrado")
                                }
                                4-> {
                                    var email = menu.pedirEmail()
                                    if (controlador.borrarUsuario(email)){
                                        println("Usuario borrado")
                                    }else println("Usuario no encontrado")


                                }
                                5->{
                                    var modificacion=0
                                    var usModificado:Usuario?
                                    do {
                                        do {
                                        var email=menu.pedirEmailModificar()
                                        usModificado=controlador.buscarUsuario(email)
                                        }while (usModificado==null)

                                        modificacion=menu.menuModificarUsuario()
                                        var cambio=menu.menuModificaciones(modificacion)
                                        controlador.modificarUsuario(usModificado,modificacion,cambio)

                                    }while (menu.masModificaciones())

                                }
                                6->{}
                                7->{menu.salida()}
                            }
                        }while (opcionAdmin!=7)

                    }else println("Rol Incorrecto")


                }else juego.adivinarNumero()

            }
            2->{

                var datos=menu.pedirDatosRegistro()
                user=Usuario(datos[0],datos[1],datos[2],datos[3].toInt(),datos[4])
                controlador.registrar(user)

            }
            3->{
                menu.salida()
            }
        }





}