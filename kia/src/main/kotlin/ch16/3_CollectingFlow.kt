package ch16

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

val letters = flow {
    log("Emitting A!")
    emit("A")
    delay(200.milliseconds)
    log("Emitting B!")
    emit("B")
}

fun main() {

    runBlocking {
        letters.collect {
            log("Collecting $it")
            delay(500.milliseconds)
        }
    }


    runBlocking {
        letters.collect {
            log("(1) Collecting $it")
            delay(500.milliseconds)
        }
        letters.collect {
            log("(2) Collecting $it")
            delay(500.milliseconds)
        }
    }
}