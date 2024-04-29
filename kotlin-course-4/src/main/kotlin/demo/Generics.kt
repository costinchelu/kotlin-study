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

    val mixedList: List<Any> = listOf("string1", BigDecimal.ZERO, BigDecimal("23.587"), "string2", BigDecimal("256"))
    val bigDecimalsOnly = getElementOfType<BigDecimal>(mixedList)
    println(bigDecimalsOnly)
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

// in Kotlin "reification" is a feature that prevents a type to be erased at runtime
// We get Cannot check for instance of erased type: T when we try this:
//fun <T> getElementOfType(inputList: List<Any>): List<T> {
//    var newList: MutableList<T> = mutableListOf()
//    for (element in inputList) {
//        if (element is T) {
//            newList.add(element)
//        }
//    }
//    return newList
//}
// we can use this technique when we want to check the type within the function using the generic type

inline fun <reified T> getElementOfType(inputList: List<Any>): List<T> {
    val newList: MutableList<T> = mutableListOf()
    for (element in inputList) {
        if (element is T) {
            newList.add(element)
        }
    }
    return newList
}

// in and out (covariant):
open class Flower {}

class Rose: Flower() {}

class Garden<out T: Flower> {

    // with out we can use a type or subtype of Flower as a return type
    val flowers: List<T> = listOf()

    fun pickFlower(i: Int): T = flowers[i]
}

fun tendGarden(roseGarden: Garden<Rose>) {

    waterGarden(roseGarden)
}

fun waterGarden(garden: Garden<Flower>) {

}

// in: use the type as a parameter
class Garden2<in T: Flower> {

    fun plantFlower(flower: T) {

    }
}


