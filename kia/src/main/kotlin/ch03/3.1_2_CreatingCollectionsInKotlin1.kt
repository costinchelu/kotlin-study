package ch03.ex1_2_CreatingCollectionsInKotlin1

import java.time.Instant

fun main() {
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    println(strings.shuffled())

    val numbers = setOf(1, 14, 2)
    println(numbers.sum())

    val now = Instant.now()
    println(Instant.now())
}
