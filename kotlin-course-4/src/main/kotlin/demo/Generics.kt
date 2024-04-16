package demo

import java.math.BigDecimal


fun main() {
    val bdList = mutableListOf(BigDecimal("-33.45"), BigDecimal("8.9925"), BigDecimal.ZERO)
    printCollection(bdList)

    bdList.printCollection2()

    append(StringBuilder("String1"), java.lang.StringBuilder("String2"))

    // in Java instanceOf can only check for a List without specifying the type of the list (a instanceOf List NOT a instanceOf List<String>)
    // in Kotlin by using "is" we must check the type of the List:
    val strings = listOf("1", "2", "3")
    if (strings is List<String>) {
        println("strings")
    }

    // for any we will need the "star projection syntax"
    val anys: List<Any> = listOf("1", 2, 3.5)
    if (anys is List<*>) {
        println("any list")
    }
}


fun <T> printCollection(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

// or as an extension Function:
fun <T> List<T>.printCollection2() {
    for (item in this) {
        println(item)
    }
}

// upper bound (extends in Java)
fun <T: Number> convertToInt(collection: List<T>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
}

// more than one upper bound
fun<T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable {
        println("Result is ${item1.append(item2)}")
    }