package ch05.ex1_2_LambdasAndCollections

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)

    // or, with lambda:
    people.maxByOrNull { it.age }?.also { println("Max age is $it") }




    val names = people.joinToString(
        separator = " ",
        transform = { p: Person -> p.name }
    )
    println(names)
}
