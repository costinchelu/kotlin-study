package ch08.AddValidNumbers

fun readNumbers(text: String): List<Int?> {
    val result = mutableListOf<Int?>()
    for (line in text.lineSequence()) {
        val numberOrNull = line.toIntOrNull()
        result.add(numberOrNull)
    }
    return result
}

fun readNumbersV2(text: String): List<Int?> = text.lineSequence().map { it.toIntOrNull() }.toList()


fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) sumOfValidNumbers += number else invalidNumbers++
    }
    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

fun addValidNumbersV2(numbers: List<Int?>) {
    val validNumbers: List<Int> = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun main() {
    val input = """
        1
        abc
        42
    """.trimIndent()
    val numbers: List<Int?> = readNumbersV2(input)
    addValidNumbersV2(numbers)

    val listOfNullable: List<Int?> = listOf(null)   // list is always non-null
    val nullableList: List<Int>? = null // list may be null, but any value it may have is non-null
    val nullableListOfNullable: List<Int?>? = null // apply null checks both when using the value of the variable and when using the value of every element in the list
}
