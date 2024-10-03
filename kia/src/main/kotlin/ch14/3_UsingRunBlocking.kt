package ch14.RunBlocking

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kia2e.coroutines.log
import kotlinx.coroutines.launch

suspend fun doSomethingSlowly() {
    log("Started operation")
    delay(500.milliseconds)
    log("I'm done")
}

fun main() {

    // this will run doSomethingSlowly function using a coroutine (an instance of a suspendable computation)
    // block of code that can be executed concurrently
    // this runBlocking block will block the current thread  until the coroutine has completed
    runBlocking {
        doSomethingSlowly()
    }


    println()


    // these coroutines are running on the same main thread, but this thread will host 3 more coroutines
    runBlocking {
        log("The #1 parent coroutine starts (by runBlocking)")
        launch {
            log("The #2 child coroutine starts (with launch) and is ready to be suspended")
            delay(500.milliseconds)
            log("The #2 child coroutine is resumed")
        }
        launch {
            log("The #3 child coroutine can run in the meantime")
        }
        log("The #1 parent coroutine has launched two more coroutines (no need to wait for children coroutines)")
    }

    println()

    log("Running in main thread [code runs sequentially]")
}