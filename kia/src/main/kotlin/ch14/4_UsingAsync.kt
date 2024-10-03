package ch14.UsingAsync

import kia2e.coroutines.log
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

suspend fun slowlyAddNumbers(a: Int, b: Int): Int {
    log("Waiting a bit before calculating $a + $b")
    delay(300.milliseconds * a)
    return a + b
}


fun main() = runBlocking {
    log("Starting the async computation")

    // Deferred type is like a Future or a Promise
    val myFirstDeferred = async { slowlyAddNumbers(2, 2) }
    val mySecondDeferred = async { slowlyAddNumbers(4, 4) }

    log("Waiting for the deferred value to be available")
    log("The first result is ready: ${myFirstDeferred.await()}")
    log("The second result is ready: ${mySecondDeferred.await()}")
}