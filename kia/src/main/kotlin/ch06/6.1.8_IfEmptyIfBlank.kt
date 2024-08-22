package ch06.ex1_8_HandlingSpecialCasesForCollectionsIfEmpty

fun main() {
    val empty = emptyList<String>()
    val full = listOf("apple", "orange", "banana")
    println(empty.ifEmpty { listOf("no", "values", "here") })
    println(full.ifEmpty { listOf("no", "values", "here") })

    val blankName = " "
    val name = "J. Doe"
    println(blankName.ifEmpty { "(unnamed)" })
    println(blankName.ifBlank { "(unnamed)" })
    println(name.ifBlank { "(unnamed)" })
}
