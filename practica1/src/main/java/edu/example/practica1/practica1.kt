package edu.example.practica1


data class User(
    val nombre: String,
    val edad: Int,
    val email: String?,
    val suscripcionActiva: Boolean
)

fun main() {
    val usuarios = mutableListOf<User>()
    println("Registro de Usuarios ")

    for (i in 1..3) {
        println("\nIntroduciendo datos para el Usuario $i ")

        print("Introduce tu nombre: ")
        val nombreUsuario = readLine() ?: "Usuario Anonimo"

        print("Introduce tu edad: ")
        val edad = readLine()?.toIntOrNull() ?: 0

        print("Introduce tu email (opcional): ")
        val email = readLine().let { if (it.isNullOrBlank()) null else it }

        print("Tienes una suscripcion activa? (si/no): ")
        val suscripcionActiva = readLine()?.trim()?.equals("si", ignoreCase = true) ?: false

        val nuevoUsuario = User(nombreUsuario, edad, email, suscripcionActiva)
        usuarios.add(nuevoUsuario)
    }

    println("\n--- Lista de Usuarios Registrados ---")
    if (usuarios.isEmpty()) {
        println("No se añadieron usuarios.")
    } else {
        for (usuario in usuarios) {
            println("\n------------------------------")
            println("Nombre: ${usuario.nombre}")
            println("Edad: ${usuario.edad}")
            println("Suscripcion activa: ${if (usuario.suscripcionActiva) "Si" else "No"}")

            if (esMayorDeEdad(usuario.edad)) {
                println("Acceso permitido")
            } else {
                println("Acceso denegado")
            }

            println("Email: ${usuario.email ?: "Email no registrado"}")

            val categoriaEdad = when {
                usuario.edad < 13 -> "Niño"
                usuario.edad in 13..17 -> "Adolescente"
                usuario.edad in 18..64 -> "Adulto"
                else -> "Adulto mayor"
            }
            println("Categoria de edad: $categoriaEdad")
            println("------------------------------")
        }
    }
}

fun esMayorDeEdad(edad: Int): Boolean {
    return edad >= 18
}
