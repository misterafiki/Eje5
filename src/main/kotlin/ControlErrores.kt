class ControlErrores {
    companion object {

    fun validarEmail(email: String): Boolean {
        var correcto = false
        var patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        if (email.matches(patron.toRegex())) correcto = true
        return correcto
    }

}

}