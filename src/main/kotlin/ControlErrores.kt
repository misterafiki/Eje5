class ControlErrores {
    companion object {

    fun validarEmail(email: String): Boolean {
        var correcto = false
        var patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        if (email.matches(patron.toRegex())) correcto = true
        return correcto
    }
        fun validarNombreApellido(dato:String):Boolean{
            var esCorrecto=false
            var abecedario="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
            for(i in dato){
                if (abecedario.contains(i.uppercase())){
                    esCorrecto=true
                }
            }
            return esCorrecto
        }
        fun validarEdad(edad:Int?):Boolean{
            var esCorrecto=false
            if (edad!= null && edad>0 && edad<=200){
                esCorrecto=true
            }
            return esCorrecto
        }
        fun validarRespuesta(respuesta:String,rango1:Int,rango2:Int):Boolean{
            var esCorrecta=false
           var opcion=respuesta.toIntOrNull()
            if (opcion in rango1..rango2){
                esCorrecta=true
            }else println("Opcion incorrecta")
            return esCorrecta
        }

}

}