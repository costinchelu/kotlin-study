package ch18

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

// just like catch, the retry will catch upstream exceptions
// we can then use the associated lambda to process the exception and return a boolean
// if it returns true a retry will be initiated (or more)
// It is important to note that retrying the collection runs all upstream operators as well:
// if any steps of the upstream flow perform side effects,
// you’ll see them executed multiple times.  In this case, you should make sure
// they’re either idempotent (i.e., applying them multiple times has the same outcome
// as applying them only once) or that repeated execution is handled correctly otherwise.
class CommunicationException : Exception("Communication failed!")

val unreliableFlow = flow {
    println("Starting the flow!")
    repeat(10) { number ->
        if (Random.nextDouble() < 0.1) throw CommunicationException()
        emit(number)
    }
}

fun main() = runBlocking {
    unreliableFlow
        .retry(5) { cause ->
            println("\nHandled: $cause")
            cause is CommunicationException
        }
        .collect { number -> print("$number ") }
}
// emitting numbers from 0 to 9 -> the flow has a 10% chance to fail and it can retry 5 times

/*
Starting the flow!
0 1 2 3 4 5
Handled: ch18.CommunicationException: Communication failed!
Starting the flow!
0 1 2 3
Handled: ch18.CommunicationException: Communication failed!
Starting the flow!
0 1 2 3 4 5 6 7 8 9
 */