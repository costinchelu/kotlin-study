package ch07.latformTypes

import ch07.Person

fun yellAtSafe(person: Person) {
    println((person.name() ?: "Anyone").uppercase() + "!!!")
}

fun main() {
    yellAtSafe(Person(null))
}
