package ch06.ex1_10_MergingCollectionsZip

data class Person(val name: String, val age: Int)

// zip processes 2 lists
fun main() {
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 22, 44, 0)
    val countries = listOf("DE", "NL", "US")
    val pair: List<Pair<String, Int>> = names.zip(ages)
    val pair2: List<Pair<String, Int>> = names zip ages
    val pair3:  List<Pair<Pair<String, Int>, String>> = names zip ages zip countries
    val list: List<Person> = names.zip(ages) { name, age -> Person(name, age) }

    println(pair)
    println(pair2)
    println(pair3)
    println(list)

    // values that don't have a counterpart in the other collection are ignored by zip
}
