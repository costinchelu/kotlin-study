package ch13.ex1_3_LambdasWithReceivers2

val appendExcl: StringBuilder.() -> Unit = { this.append("!") }

fun main() {
    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder)                    // Hi!
    println(buildString(appendExcl))          // !

    // ----------------------------------------------------

    val map = mutableMapOf(1 to "one")
    map.apply { this[2] = "two" }
    with(map) { this[3] = "three" }
    println(map)                               // {1=one, 2=two, 3=three}
}
