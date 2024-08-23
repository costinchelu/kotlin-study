package ch10.FunctionsPassedAsArguments

// higher order function -> function accepting an operator (returns Unit)
// performs an arbitrary operation on 2 integers and prints something
fun twoAndThreeV1(operation: (Int, Int) -> Int) {
    val result: Int = operation(2, 3)
    println("The result is $result")
}

// we can specify names for parameters of a function type (to improve readability)
fun twoAndThreeV2(operation: (operandA: Int, operandB: Int) -> Int) {
    val result: Int = operation(2, 3)
    println("The result is $result")
}

// extension function acting as a higher order function (accepting a predicate)
fun String.filter(predicate: (Char) -> Boolean): String {
    // buildString provides a StringBuilder
    return buildString {
        for (char in this@filter) {
            // check if each character of the String satisfies the predicate
            if (predicate(char)) append(char)
        }
    }
}

fun main() {
    twoAndThreeV1 { a, b -> a + b }           // The result is 5
    twoAndThreeV1 { a, b -> a * b + 2 }       // The result is 8


    twoAndThreeV2 { a, b -> a + b }                                       // The result is 5


    println("ab1cTabc".filter { it in 'a'..'z' })                    // abcabc
}
