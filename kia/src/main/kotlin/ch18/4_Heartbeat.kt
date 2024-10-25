package ch18

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

// by default all coroutine builders (including runBlocking) create
// a regular non-supervised coroutine
// that is why when one coroutine terminates (uncaught exception),
// the other child coroutines also get cancelled
fun main(): Unit = runBlocking {
    launch {
        child(300.milliseconds, "Heartbeat-1")
    }

    launch {
        child(500.milliseconds,"Heartbeat-2")
    }

    launch {
        delay(1.seconds)
        throw UnsupportedOperationException("Ow!")
    }
}

suspend fun child(delay: Duration, message: String) {
    try {
        while (true) {
            println(message)
            delay(delay)
        }
    } catch (e: Exception) {
        println("Heartbeat terminated: $e")
        throw e
    }
}
/*
Heartbeat-1
Heartbeat-2
Heartbeat-1
Heartbeat-2
Heartbeat-1
Heartbeat-1
Heartbeat terminated: kotlinx.coroutines.JobCancellationException: Parent job is Cancelling; job=BlockingCoroutine{Cancelling}@629f0666
Heartbeat terminated: kotlinx.coroutines.JobCancellationException: Parent job is Cancelling; job=BlockingCoroutine{Cancelling}@629f0666
Exception in thread "main" java.lang.UnsupportedOperationException: Ow!
 */