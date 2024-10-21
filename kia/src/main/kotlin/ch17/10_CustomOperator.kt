package ch17

import kia2e.coroutines.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

// implementing a new operator
// returning a Flow means it will be an intermediate operation
// first, the upstream flow is collected, then it is processed and in the end a new flow is emitted
fun Flow<Double>.averageOfLast(n: Int): Flow<Double> =
    flow {
        val numbers = mutableListOf<Double>()
        collect {
            if (numbers.size >= n) {
                numbers.removeFirst()
            }
            numbers.add(it)
            emit(numbers.average())
        }
    }

// invoke the operator on an upstream flow and collect its downstream flow
fun main() = runBlocking {
    flowOf(1.0, 2.0, 30.0, 121.0)
        .averageOfLast(3)
        .collect { log("$it ") }
}
/*
0 [main] 1.0
7 [main] 1.5
7 [main] 11.0
7 [main] 51.0
 */