package ch08.ex1_4_KotlinMakesNumberConversionsExplicit


fun printALong(l: Long) = println(l)


fun main() {
    val x = 1
    println(x.toLong() in listOf(1L, 2L, 3L))   // true


    val b: Byte = 1
    val l: Long = b + 1L
    printALong(2)                   // 2


    println(Int.MAX_VALUE + 1)      // -2147483648
    println(Int.MIN_VALUE - 1)      // 2147483647


    println("42".toInt())


    println("seven".toIntOrNull())  // null


    println("trUE".toBoolean())     // true
    println("7".toBoolean())        // false
    println(null.toBoolean())       // false
}
