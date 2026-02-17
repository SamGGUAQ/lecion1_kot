package edu.example.lesson2

fun printHello() {
    println ("Hello World")
}

//fun main(args: Array<String>) {
//    println("Hello, world!")
//}
fun main(args: Array<String>){
    //printHello()
    println("Hello, ${args[0]}")
}
