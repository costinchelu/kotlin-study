package ch02.ex1_2_DeclaringFunctionsWithParametersAndReturnValues

// expression body
// in Kotlin if is an expression and not a statement
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// type inference for one-liner
fun maxOneLine(a: Int, b: Int) = if (a > b) a else b

fun main() {
    println(max(1, 2))
}
