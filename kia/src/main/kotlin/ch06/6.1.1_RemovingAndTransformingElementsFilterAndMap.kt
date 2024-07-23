package ch06.ex1_1_1_RemovingAndTransformingElementsFilterAndMap


data class Person(val name: String, val age: Int)


fun main() {
    val list = listOf(1, 2, 3, 4)
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    val numbersList = listOf(1, 2, 3, 4, 5, 6, 7)
    val numbersMap = mapOf(0 to "zero", 1 to "one")


    println(list.filter { it % 2 == 0 })
    println(people.filter { it.age > 30 })
    val filtered = numbersList.filterIndexed { index, element -> index % 2 == 0 && element > 3 }
    println(filtered)


    println(list.map { it * it })
    println(people.map { it.name })
    val mapped = numbersList.mapIndexed { index, element -> index + element }
    println(mapped)
    println(numbersMap.mapValues { it.value.uppercase() })
}
