package ch18

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

// if we need to transform the flow we can attach a map lambda
// but we also need to make sure to understand that catch operator only operates on its upstream (catching
// exc that occurred prior in the flow-processing pipeline
// To catch an exception that occurs inside the collect lambda, you can wrap the invocation of collect in a try-catch block
fun main() = runBlocking {
    exceptionalFlow
        .map { it * 2 }
        .catch { cause ->
            println("\nHandled $cause")
            emit(Int.MIN_VALUE) }
//      .onEach { throw UnhappyFlowException() }
        .collect{ print("$it ") }
}
/*
0 2 4 6 8
Handled ch18.UnhappyFlowException
-2147483648
 */