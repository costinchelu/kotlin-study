package ch18

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class UnhappyFlowException : Exception()

// flows can also throw exceptions
// when collected this flow will emit 5 elements (Int 0 to 4), then will throw a custom exception
val exceptionalFlow = flow {
    repeat(5) { number -> emit(number) }
    throw UnhappyFlowException()
}

fun main() = runBlocking {
    val transformedFlow = exceptionalFlow.map { it * 2 }

    try {
        transformedFlow.collect { print("$it ") }
    } catch (u: UnhappyFlowException) {
        println("\nHandled: $u")
    }
    // 0 2 4 6 8
    // Handled: UnhappyFlowException
}