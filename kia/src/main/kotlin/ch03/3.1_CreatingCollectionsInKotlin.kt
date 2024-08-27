package ch03.CreatingCollectionsInKotlin

import java.time.Instant

val set = setOf(1, 7, 53)
val list = listOf(1, 7, 53)
val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun main() {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)


    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    println(strings.shuffled())

    val numbers = setOf(1, 14, 2)
    println(numbers.sum())

    val now = Instant.now()
    println(Instant.now())
}
