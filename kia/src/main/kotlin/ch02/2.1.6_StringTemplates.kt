package ch02.ex1_6_1_StringTemplates

fun main() {
    val input = readln()
    val name = if (input.isNotBlank()) input else "Kotlin"
    println("Hello, $name!")

    if (name.isNotBlank()) {
        println("Hello, ${name.length}-letter person!")
    }

    println("Hello, ${if (name.isBlank()) "someone" else name}!")
}
