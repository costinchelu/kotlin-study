package ch18

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking

//this is a more convenient way to catch flow exceptions
fun main() = runBlocking {
    exceptionalFlow
        .catch { cause ->
            println("\nHandled: $cause")
            emit(Int.MIN_VALUE)
        }
        .collect { print("$it ") }
}
/*
0 1 2 3 4
Handled: ch18.UnhappyFlowException
-2147483648
 */