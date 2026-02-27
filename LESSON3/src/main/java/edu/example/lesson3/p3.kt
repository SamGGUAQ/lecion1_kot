package edu.example.lesson3

// 1. Interfaz que define comportamiento
interface Prestable {
    fun prestar()
}

// 2. Clase Abstracta que define la identidad y el estado
abstract class ElementoMultimedia(val titulo: String, val anioPublicacion: Int)

// 3. Clase Libro que hereda estado e implementa el comportamiento
class Libro(titulo: String, anioPublicacion: Int) : ElementoMultimedia(titulo, anioPublicacion), Prestable {

    // Implementación obligatoria de la interfaz
    override fun prestar() {
        println("El libro '$titulo' ha sido prestado exitosamente.")
    }

    // 4. Companion Object con una constante
    companion object {
        const val TIPO_RECURSO = "Libro"
    }
}

// 5. Función de Extensión para añadir funcionalidad sin heredar
fun Libro.esAntiguo(): Boolean {
    return this.anioPublicacion < 1950
}

// --- PRUEBA DE IMPLEMENTACIÓN ---
fun main() {
    // Verificación 1: Instanciación
    val miLibro = Libro("Cien años de soledad", 1967)
    val libroViejo = Libro("Don Quijote de la Mancha", 1605)

    // Verificación 2: Prueba de Herencia (Acceso a propiedades de la clase abstracta)
    println("Recurso: ${Libro.TIPO_RECURSO}") // Verificación 5: Companion Object
    println("Título: ${miLibro.titulo}, Año: ${miLibro.anioPublicacion}")

    // Verificación 3: Prueba de Interfaz
    miLibro.prestar()

    // Verificación 4: Prueba de Función de Extensión
    println("¿Es '${miLibro.titulo}' antiguo? ${miLibro.esAntiguo()}")
    println("¿Es '${libroViejo.titulo}' antiguo? ${libroViejo.esAntiguo()}")
}