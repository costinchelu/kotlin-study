package ch15.GlobalScope

import kia2e.coroutines.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds


// by using CoroutineScope, the parent coroutine will not wait for child coroutines to finish
// Using GlobalScope breaks the hierarchy typically established out of the box when using structured concurrency
fun main() {
    runBlocking {
        log("Parent start")
        GlobalScope.launch {
            log("Child 1 started")
            delay(1.seconds)
            launch {
                log("Grandchild started")
                delay(250.milliseconds)
                log("Grandchild done!")
            }
            log("Child 1 done!")
        }
        GlobalScope.launch {
            log("Child 2 started")
            delay(500.milliseconds)
            log("Child 2 done!")
        }
        log("Parent done!")
    }
}
/*
0 [main] Parent start
9 [DefaultDispatcher-worker-1] Child 1 started
9 [main] Parent done!
10 [DefaultDispatcher-worker-2] Child 2 started
 */