package ch08.KotlinCollectionsAndJavaCollectionsAreDeeplyRelated

import ch08.CollectionUtils

// Kotlin - collections.kt
// Java code can modify the collection even if it is declared read-only in Kotlin
fun printInUppercase(list: List<String>) {
    println(CollectionUtils.uppercaseAll(list))
    println(list.first())
}

fun main() {
    val list = listOf("a", "b", "c")
    printInUppercase(list)
}
