package Logica

import Usuario

class ComprobarLogin {

    fun comprobar(usuario: Usuario?, pass:String):Boolean{
        var passCorrecta=false
        if (usuario?.pass==pass){
            passCorrecta=true
        }
        return passCorrecta
    }



}