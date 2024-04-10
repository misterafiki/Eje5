package Presentacion

import Logica.ControlErrores
import Usuario

class Registrar {
    fun registrar():Usuario {
        var email =""
        var nombre =""
        var apellido1 =""
        var apellido2=""
        var edad=0
        println("Registro de usuario:")
        do {
            print("Email: ")
            email = readLine()!!
        }while (!ControlErrores.validarEmail(email))
        do {
            print("Nombre: ")
            nombre = readLine()!!
        }while (!ControlErrores.validarNombreApellido(nombre))
        do {
            print("Primer Apellido: ")
            apellido1 = readLine()!!
        }while (!ControlErrores.validarNombreApellido(apellido1))
        do {
            print("Segundo Apellido: ")
            apellido2= readLine()!!
        }while (!ControlErrores.validarNombreApellido(apellido2))
        do {
            print("Edad: ")
            edad = readLine()?.toIntOrNull() ?: 0
        }while (!ControlErrores.validarEdad(edad))

        print("Clave de acceso: ")
        var claveAcceso = readLine()!!


        val usuario = Usuario(email, nombre, apellido1+" "+apellido2, edad, claveAcceso)
        return usuario
    }
}