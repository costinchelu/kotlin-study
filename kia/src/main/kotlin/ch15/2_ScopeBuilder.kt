package ch15.ScopeBuilder

import kia2e.coroutines.log
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

suspend fun generateValue(): Int {
    delay(500.milliseconds)
    return Random.nextInt(0, 10)
}

// coroutineScope function group coroutines waiting for them to finish
suspend fun computeSum() {
    log("Computing a sum...")
    val sum = coroutineScope {
        val a = async { generateValue() }
        val b = async { generateValue() }
        val c = async { generateValue() }
        val d = async { generateValue() }
        a.await() + b.await() + c.await() + d.await()
    }
    log("Sum is $sum")
}

fun main() = runBlocking {
    computeSum()
}