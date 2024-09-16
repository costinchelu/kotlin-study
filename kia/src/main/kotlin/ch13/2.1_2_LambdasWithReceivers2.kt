package ch13.LambdasWithReceivers2

val appendExcl: StringBuilder.() -> Unit = { this.append("!") }

fun main() {
    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder)                    // Hi!
    println(buildString(appendExcl))          // !

    // ----------------------------------------------------

    // apply vs with is another example of functions that invoke the argument of an extension function type on the provided receiver
    // apply is declared as an extension to that receiver but with takes it as an argument
    // the main difference is that apply returns the receiver itself but with returns the result of calling the lambda
    val map = mutableMapOf(1 to "one")

    map.apply { this[2] = "two" }

    with(map) { this[3] = "three" }

    println(map)                               // {1=one, 2=two, 3=three}
}
