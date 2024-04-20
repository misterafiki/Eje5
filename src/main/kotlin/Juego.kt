class Juego {
    fun adivinarNumero() {

        println("¡Bienvenido a la aplicación ADIVINA EL NÚMERO!")

        println("El juego consiste en adivinar un número secreto comprendido entre el número 1 y el número 20")

        var cantidadPartidasPerdidas = 0
        var cantidadPartidasGanadas = 0
        var continuarJugando = true

        while (continuarJugando) {
            val turnoMaximo = 10
            var turnoMinimo = 0
            val numeroSecreto: Int = (1..20).random()

            while (turnoMinimo < turnoMaximo) {
                turnoMinimo++

                println("Dime tu número y te diré si es el número secreto")
                val numeroSeleccionado: Int = readln().toInt()

                if (numeroSeleccionado == numeroSecreto) {
                    println("¡ENHORABUENA! Has adivinado el número secreto, que era el número $numeroSecreto")

                    cantidadPartidasGanadas++
                    turnoMinimo = turnoMaximo

                } else {
                    println("Lo siento ese no es el número secreto")
                }

                if (turnoMinimo == turnoMaximo && numeroSeleccionado != numeroSecreto) {
                    println("Lo siento, se han agotado los turnos, el número secreto es el número $numeroSecreto")

                    cantidadPartidasPerdidas++
                }

            }

            println("¿Quieres seguir jugando? (s/n)")

            val respuesta = readLine()!!.toLowerCase()

            if (respuesta != "s") {
                continuarJugando = false
            }

        }

        val cantidadPartidasJugadas = cantidadPartidasGanadas + cantidadPartidasPerdidas

        println("Cantidad de partidas jugadas: $cantidadPartidasJugadas")

        println("Cantidad de partidas ganadas: $cantidadPartidasGanadas")

    }

}