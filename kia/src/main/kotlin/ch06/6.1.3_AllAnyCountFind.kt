package ch06.ex1_3_1_AllAnyCountFind

data class Person(val name: String, val age: Int)

val canBeInClub27: (Person) -> Boolean = { p: Person -> p.age <= 27 }

fun main() {
    val list = listOf(1, 2, 3)
    val people = listOf(Person("Alice", 27), Person("Bob", 31))

    // are all elements satisfying this condition? (returns boolean)
    // !!! it returns true if called on an empty collection
    println(list.all { it != 4 })
    println(emptyList<Int>().all { it != 4 })

    // !!! it returns true if called on an empty collection
    println(list.none { it == 4 })

    // is at least one element satisfying this condition? (returns boolean)
    println(list.any { it != 3 })


    println(people.all(canBeInClub27))


    // returns just the first element satisfying the condition (or null) -> synonym with firstOrNull()
    println(people.find(canBeInClub27))
}
