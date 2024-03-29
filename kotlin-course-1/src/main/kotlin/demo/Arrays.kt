package demo

import java.math.BigDecimal

fun main() {

    val names = arrayOf("John", "Jane", "Jill", "Joe")

    val longs1 = arrayOf(1L, 2L, 3L, 4L)
    val longs2 = arrayOf<Long>(1, 2, 3, 4)
    val ints1 = arrayOf(1, 2, 3, 4)

    println(longs1 is Array<Long>)

    // custom array with even numbers starting from 0 to 30
    var customArray = Array(16) {i -> i * 2}

    for (number in customArray) {
        print(" $number")
    }
    println()
    customArray.forEach { number -> print(" $number") }
    println()

    val someArray: Array<Long>
    someArray = arrayOf(1, 2, 3)

    val mixedArray = arrayOf("hi", 56, BigDecimal(10.6), 'a', 24.4)
    for (element in mixedArray) {
        print(" $element")
    }
    println("\n" + mixedArray.isArrayOf<Any>())

//    DummyClass().printNumbers(customArray)   -> not working | we need an array of primitives
    val customArray2 = intArrayOf(3, 6, 9, 12, 15)
    DummyClass().printNumbers(customArray2)
    DummyClass().printNumbers(customArray.toIntArray())

    val intArrayGeneral: Array<Int> = customArray2.toTypedArray()
}