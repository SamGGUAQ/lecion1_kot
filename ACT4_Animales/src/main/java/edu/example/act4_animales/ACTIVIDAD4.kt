package edu.example.act4_animales

interface Comestible{
    fun formaDeComer(): String
    fun CaloriasAportadas(): Int
}
abstract class Animal(val nombre: String, val edad: Int, val peso: Double, val habitat: Habitat, val cuidador: Cuidador) {
    abstract fun hacerSonido(): String
    open fun mostrarInfo() = println("Animal: $nombre   $edad años  $peso kg    Hábitat: ${habitat.tipo}\nCuidador: ${cuidador.nombre}  ${cuidador.aniosExperiencia} años   ${cuidador.especialidad}")
}
abstract class Fruta(val nombre: String, val color: String, val peso: Double, val nivelDulzura: Int,
                     val origen: Origen, val infoNutricional: InformacionNutricional) {
    abstract fun tipoSabor(): TipoSabor
}
enum class TipoSabor { DULCE, ACIDO, CITRICO, AMARGO }

class Leon(habitat: Habitat, cuidador: Cuidador) : Animal("León", 5, 190.0, habitat, cuidador) {
    override fun hacerSonido() = "Rugido"
}

class Gallina(habitat: Habitat, cuidador: Cuidador) : Animal("Gallina", 2, 3.0, habitat, cuidador), Comestible {
    override fun hacerSonido() = "Cacareo"
    override fun formaDeComer() = "(Asada/Cocida)"
    override fun CaloriasAportadas() = 165
}

class Vaca(habitat: Habitat, cuidador: Cuidador) :
    Animal("Vaca", 4, 500.0, habitat, cuidador), Comestible {
    override fun hacerSonido() = "Mugido"
    override fun formaDeComer() = "(Asada/Cocida)"
    override fun CaloriasAportadas() = 250
}

// --- FRUTAS ---
class Manzana(origen: Origen, info: InformacionNutricional) :
    Fruta("Manzana", "Roja", 0.2, 8, origen, info), Comestible {
    override fun tipoSabor() = TipoSabor.DULCE
    override fun formaDeComer() = "Se lava y puede pelarse"
    override fun CaloriasAportadas() = infoNutricional.calorias
}

class Naranja(origen: Origen, info: InformacionNutricional) :
    Fruta("Naranja", "Naranja", 0.25, 6, origen, info), Comestible {
    override fun tipoSabor() = TipoSabor.CITRICO
    override fun formaDeComer() = "En jugo o gajos"
    override fun CaloriasAportadas() = infoNutricional.calorias
}
class Platanos(origen: Origen, info: InformacionNutricional) :
    Fruta("Platano", "Amarillo", 0.5, 9, origen, info), Comestible {
    override fun tipoSabor() = TipoSabor.DULCE
    override fun formaDeComer() = "En batidos"
    override fun CaloriasAportadas() = infoNutricional.calorias
}
data class Habitat(val tipo: String, val temperaturaPromedio: Double, val region: String)
data class Cuidador(val nombre: String, val aniosExperiencia: Int, val especialidad: String)
data class Origen(val pais: String, val region: String, val productor: String)
data class InformacionNutricional(val calorias: Int, val azucar: Double, val fibra: Double, val proteinas: Double)

fun main() {

    val sabana = Habitat("Sabana", 30.0, "África")
    val granja = Habitat("Granja", 20.0, "Global")

    val cuidadorZoo = Cuidador("Carlos", 10, "Felinos")
    val granjero = Cuidador("Juan", 25, "Aves")

    val origenMex = Origen("México", "Chihuahua", "Huerta Sol")
    val origenBr  = Origen("Brasil", "Amazonas", "Granja Feliz")

    val infoManzana = InformacionNutricional(52, 10.0, 2.4, 0.3)
    val infoNaranja = InformacionNutricional(45, 15.0, 1.2, 1.0)
    val infoPlatano = InformacionNutricional(89, 5.0, 1.8, 1.0)

    val LISTA: List<Any> = listOf(
        Leon(sabana, cuidadorZoo),
        Gallina(granja, granjero),
        Vaca(granja, granjero),
        Manzana(origenMex, infoManzana),
        Naranja(origenMex, infoNaranja),
        Platanos(origenBr, infoPlatano)
    )

    for (item in LISTA) {
        when (item) {
            is Animal -> {
                item.mostrarInfo()
                println("Sonido: ${item.hacerSonido()}")
            }
            is Fruta -> {
                println("Fruta: ${item.nombre} | Color: ${item.color} | Sabor: ${item.tipoSabor()}")
                println("Origen: ${item.origen.pais}")
            }
        }

        if (item is Comestible) {
            println("Comestible: Si")
            println("Forma de comer: ${item.formaDeComer()}")
            println("Calorias: ${item.CaloriasAportadas()}")
        } else {
            println("Comestible: No")
        }
    }
}
