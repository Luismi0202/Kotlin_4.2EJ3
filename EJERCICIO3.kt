import kotlin.math.pow
import kotlin.math.round

class Persona(val peso: Double, val altura: Double){
    var nombre: String = "Desconocido"
    private val imc: Double = calcularImc()

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    private fun calcularImc(): Double = round(peso/altura.pow(2))

    fun saludar(nombre: String):String = "Hola $nombre"

    private fun alturaEncimaMedia(altura: Double): String = if(altura >= 1.75) "Su altura está encima de la media" else "Su altura está en la media"

    private fun pesoEncimaMedia(peso: Double): String = if(peso >=70.0) "Su peso está encima de la media" else "Su peso está en la media"

    private fun obtenerDescImc(imc:Double): String{
        return when{
            imc < 18.5 -> "peso insuficiente"
            imc >= 18.5 && imc <= 24.9 -> "peso saludable"
            imc >= 25.0 && imc <= 29.9 -> "sobrepeso"
            else-> "obesidad"
        }
    }

    override fun toString(): String {
        return "Nombre: $nombre, Peso: $peso kg (${pesoEncimaMedia(peso)}, Altura: $altura (${alturaEncimaMedia(altura)}), IMC: $imc (${obtenerDescImc(imc)})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false
        return this.nombre == other.nombre && this.peso == other.peso && this.altura == other.altura
    }
}

fun mostrarInfo(personas:List<Persona>){
    for(persona in personas){
        println(persona.saludar(persona.nombre))
        println(persona)
    }
}

fun main(){
    val persona1 = Persona("Juan",120.0,1.72)
    val persona2 = Persona("Federico",85.0,1.76)
    val persona3 = Persona("Juana",20.0,1.67)
    val persona4 = Persona("Paca",63.7,1.70)

    val personas = listOf(persona1,persona2,persona3,persona4)
    mostrarInfo(personas)
}