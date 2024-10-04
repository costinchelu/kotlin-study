package ch15.MultipleCoroutines

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun main() {
    runBlocking {
        log("Parent start")
        launch {
            log("Child 1 started")
            delay(1.seconds)
            launch {
                log("Grandchild started")
                delay(250.milliseconds)
                log("Grandchild done!")
            }
            log("Child 1 done!")
        }
        launch {
            log("Child 2 started")
            delay(500.milliseconds)
            log("Child 2 done!")
        }
        log("Parent done!")
    }
}