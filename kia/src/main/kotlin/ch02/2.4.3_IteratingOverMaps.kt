package ch02.ex4_3_1_IteratingOverMaps

import java.util.TreeMap

fun main() {
    // using Treemap to keep the natural order of element keys
    val binaryReps = TreeMap<Char, String>()


    for (c in ' '..'~') {
        val binary = c.code.toString(radix = 2)
        // map.put() way for Kotlin (between the brackets we assign c as key and binary as value):
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }


    val list = listOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    for (indexedElement in list.withIndex()) {
        println("${indexedElement.index}: ${indexedElement.value}")
    }
}
