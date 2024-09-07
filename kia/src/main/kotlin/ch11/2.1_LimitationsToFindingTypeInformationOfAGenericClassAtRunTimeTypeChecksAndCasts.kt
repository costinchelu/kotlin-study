package ch11.LimitationsToFindingTypeInformationOfAGenericClassAtRunTimeType


fun printSumV1(c: Collection<*>) {
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}


fun printSumV2(c: Collection<Int>) {
    when (c) {
        is List<Int> -> println("List sum: ${c.sum()}")
        is Set<Int> -> println("Set sum: ${c.sum()}")
    }
}

fun main() {
    printSumV2(listOf(1, 2, 3))                     // List sum: 6
    printSumV2(setOf(3, 4, 5))                      // Set sum: 12
}
