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
    // If a lambda is the only argument, you’ll definitely want to write it without the parentheses
    // If you want to pass two or more lambdas, you can’t move more than one out, so it’s usually better to keep all of them inside the parentheses.

    val getAge: (Person) -> Int = { p: Person -> p.age}
    val getAgeV2 = Person::age
    people.maxByOrNull(getAge)

    val names: String = people.joinToString(
        separator = " ",
        transform = { p: Person -> p.name }
    )

    val namesV2: String = people.joinToString(" ") { p: Person -> p.name }
    println(names)
    println(namesV2)
}
