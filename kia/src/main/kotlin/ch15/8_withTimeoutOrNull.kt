package ch15.TimeoutOrNull

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

suspend fun calculateSomething(): Int {
    delay(3.seconds)
    return 2 + 2
}

fun main() = runBlocking {
    log("Start")

    val quickResult = withTimeoutOrNull(500.milliseconds) {
        calculateSomething()
    }
    log(quickResult)
    // null

    val slowResult = withTimeoutOrNull(5.seconds) {
        calculateSomething()
    }
    log(slowResult)
    // 4
}