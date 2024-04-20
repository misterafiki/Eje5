class Menu {



        fun menuPrincipal() :Int{
            var respuesta=0
            var r=""
            do {
                println("Bienvenido al sistema: \n 1.- Login\n2.- Registrar\n3.- Salir")
                r=readln()
            }while (!ControlErrores.validarRespuesta(r,1,3))
            respuesta=r.toInt()
            return respuesta
        }

        fun menuAdmin() :Int{
            var respuesta=0
            var r=""
            do {
                println("Menú de administrador:\n1.- Añadir usuario\n" +
                        "2.- Mostrar usuarios\n" +
                        "3.- Buscar usuario por email\n" +
                        "4.- Borrar usuario\n" +
                        "5.- Modificar usuario\n" +
                        "6.- Cambiar permisos de usuario\n" +
                        "7.- Salir")
                r= readln()
            }while (!ControlErrores.validarRespuesta(r,1,7))
            respuesta=r.toInt()
            return respuesta
        }
        fun elegirRol():Int?{
            println("Como quieres entrar:\n1->Usuario Estandar\n2->Administrador")
            var respuesta=readln().toIntOrNull()
            return respuesta
        }

    fun pedirDatosLogin():ArrayList<String>{
        var datos=ArrayList<String>()
        println("Introduce tu email")
        datos.add(readln())
        println("escribe tu contraseña")
        datos.add(readln())
        return datos
    }
    fun pedirDatosRegistro():ArrayList<String> {
        var email =""
        var nombre =""
        var apellido1 =""
        var apellido2=""
        var edad=0
        var datos=ArrayList<String>()
        println("Registro de usuario:")
        do {
            print("Email: ")
            email = readLine()!!
            datos.add(email)
        }while (!ControlErrores.validarEmail(email))
        do {
            print("Nombre: ")
            nombre = readLine()!!
            datos.add(nombre)
        }while (!ControlErrores.validarNombreApellido(nombre))
        do {
            print("Primer Apellido: ")
            apellido1 = readLine()!!

        }while (!ControlErrores.validarNombreApellido(apellido1))

        do {
            print("Segundo Apellido: ")
            apellido2= readLine()!!
            datos.add(apellido1+" "+apellido2)
        }while (!ControlErrores.validarNombreApellido(apellido2))
        do {
            print("Edad: ")
            edad = readLine()?.toIntOrNull() ?: 0
        }while (!ControlErrores.validarEdad(edad))
        datos.add(edad.toString())
        print("Clave de acceso: ")
        var claveAcceso = readLine()!!
        datos.add(claveAcceso)
        return datos
    }
    fun pedirEmail():String{
        println("Introducel el email a buscar")
        var email= readln()

       return email
    }
    fun pedirEmailModificar():String{

        println("Introducel el email a modificar")
        var email= readln()

        return email
    }
    fun salida(): String {
        var despedida="¡Hasta luego!"
        return despedida
    }

    fun menuModificarUsuario():Int{
        var opcion=""
        do {
            println("Que quieres modificar: \n1->Nombre\n2->Apellidos\n3->Edad")
            opcion= readln()
        }while (!ControlErrores.validarRespuesta(opcion,1,3))
        var opcionCorrecta=opcion.toInt()
        return opcionCorrecta
    }
    fun menuModificaciones(modificacion:Int):String{
        var cambio=""
        if (modificacion==1){

            do {
                println("Introduce el nuevo nombre")
                cambio= readln()
            }while (!ControlErrores.validarNombreApellido(cambio))

        }else if (modificacion==2){
            var apellido1=""
            var apellido2=""
            do {
                println("Introduce el primer apellido")
                apellido1= readln()
                println("Introduce el segundo apellido")
                apellido2= readln()

            }while (!ControlErrores.validarNombreApellido(apellido1)||!ControlErrores.validarNombreApellido(apellido2))
            cambio=apellido1+" "+apellido2
        }else if (modificacion==3){
            var edad:Int?=0
            do {
                println("Dime la nueva edad")
                edad= readln().toIntOrNull()
            }while (!ControlErrores.validarEdad(edad))
            cambio=edad.toString()
        }
        return cambio
    }
    fun masModificaciones():Boolean{
        var mas=false
        println("Quieres modificar algo mas y/n")
        var respuesta= readln()
        if (respuesta.uppercase()=="Y"){
            mas=true
        }
        return mas
    }

}