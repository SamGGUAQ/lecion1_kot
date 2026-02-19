package edu.example.lesson2

//// Will assign kotlin.Unit
//val isUnit = println("This is an expression")
//fun main(){
//    println(isUnit)
//}
val temperature = 10
val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
val isHot = if (temperature > 50) true else false
fun main(){
    //println(isHot)
    println(message)
}



