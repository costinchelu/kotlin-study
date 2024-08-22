package ch10.CallingFunctionsPassedAsArguments

fun twoAndThree(operation: (operandA: Int, operandB: Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}


fun String.filter(predicate: (Char) -> Boolean): String {
    return buildString {
        for (char in this@filter) {
            if (predicate(char)) append(char)
        }
    }
}


fun main() {
    twoAndThree { operandA, operandB -> operandA + operandB }               // The result is 5
    twoAndThree { alpha, beta -> alpha + beta }                             // The result is 5


    println("ab1c".filter { it in 'a'..'z' })                           // abc
}
