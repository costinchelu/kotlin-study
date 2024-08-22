package ch10.FunctionsPassedAsArguments

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result: Int = operation(2, 3)
    println("The result is $result")
}

fun main() {
    twoAndThree { a, b -> a + b }           // The result is 5
    twoAndThree { a, b -> a * b + 2 }       // The result is 8
}
