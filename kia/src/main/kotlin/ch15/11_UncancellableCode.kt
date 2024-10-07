package ch15.UncancellableCode

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds


// suspending functions need to provide the logic that makes them cancellable themselves
suspend fun doCpuHeavyWork(): Int {
    log("I'm doing work!")
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
        // including a call to delay introduces a point at which this function can be cancelled
//        delay(100.milliseconds)
    }
    return counter
}

// because doCpuHeavyWork() can't be cancelled we will print "I'm doing work!" five times
fun main() {
    runBlocking {
        val myJob = launch {
            repeat(5) {
                doCpuHeavyWork()
                // we can check if a coroutine is active using isActive or ensureActive() that will
                // throw CancellationException if the routine is not active
//                ensureActive()
            }
        }
        delay(600.milliseconds)
        myJob.cancel()
    }
}