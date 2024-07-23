package ch05.ex4_3_UsingAlso


// like apply also takes a receiver object, perform actions on it (lambda) and then return the receiver object
// main difference is that within the lambda of also, we can access the receiver object as an argument (it or giving it a name)
// we can use also to execute additional effects on the receiver (also do this on it....)

fun main() {
    val fruits = listOf("Apple", "Banana", "Cherry")
    val uppercaseFruits = mutableListOf<String>()
    val reversedLongFruits = fruits
        .map { it.uppercase() }
        .also { uppercaseFruits.addAll(it) }
        .filter { it.length > 5 }
        .also { println(it) }   /* [BANANA, CHERRY]  */
        .reversed()
    println(uppercaseFruits)    // [APPLE, BANANA, CHERRY]
    println(reversedLongFruits) // [CHERRY, BANANA]
}
