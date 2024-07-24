package ch07.ex1_11_1_PlatformTypes

import ch07.Person

fun yellAtSafe(person: Person) {
    println((person.name() ?: "Anyone").uppercase() + "!!!")
}

fun main() {
    yellAtSafe(Person(null))
}
