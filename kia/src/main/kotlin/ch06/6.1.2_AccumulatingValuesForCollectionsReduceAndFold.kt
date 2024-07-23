package ch06.ex1_2_AccumulatingValuesForCollectionsReduceAndFold

data class Person(val name: String, val age: Int)


fun main() {
    val list = listOf(1, 2, 3, 4)
    val people = listOf(Person("Aleksei", 29), Person("Natalia", 28))

    // don't call reduce on an empty collection
    // reduce starts with the first element of the collection in the accumulator, the lambda is then called
    // with the accumulator and the second element. The result becomes the accumulator.
    val summed: Int = list.reduce { acc, element -> acc + element }
    println(summed)         // 10

    val multiplied: Int = list.reduce { acc, element -> acc * element }
    println(multiplied)     // 24

    // fold uses an arbitrary start value as an accumulator
    val folded = people.fold("") { acc, person -> acc + person.name }
    println(folded)             // AlekseiNatalia


    // runningReduce/Fold will create a list with reduced items

    val summedList: List<Int> = list.runningReduce { acc, element -> acc + element }
    println(summedList)            // [1, 3, 6, 10]

    val multipliedList: List<Int> = list.runningReduce { acc, element -> acc * element }
    println(multipliedList)         // [1, 2, 6, 24]

    println(people.runningFold("") { acc, person -> acc + person.name })     // [, Aleksei, AlekseiNatalia]
}
