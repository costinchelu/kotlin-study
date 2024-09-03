package ch10.InliningCollectionOperations

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31))

fun main() {
    val result = mutableListOf<Person>()
    for (person in people) {
        if (person.age < 30) result.add(person)
    }
    println(result)         // [Person(name=Alice, age=29)]

    // in Kotlin, the filter and map functions are declared as inline
    println(people.filter { it.age < 30 })          // [Person(name=Alice, age=29)]


    println(people.filter { it.age > 30 }.map(Person::name))            // [Bob]
    println(people.filter { it.age > 30 }.map {it.name})                // [Bob]
}
