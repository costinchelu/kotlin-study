package ch18

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

// one solution is to avoid throwing exceptions (catch them)
fun main(): Unit = runBlocking {
    launch {
        child(500.milliseconds, "Heartbeat-1")
    }

    launch {
        child(500.milliseconds,"Heartbeat-2")
    }

    launch {
        try {
            delay(1.seconds)
            throw UnsupportedOperationException("Ow!")
        } catch (u: UnsupportedOperationException) {
            println("Caught $u")
        }
    }
}
/*
Heartbeat-1
Heartbeat-2
Heartbeat-1
Heartbeat-2
Caught java.lang.UnsupportedOperationException: Ow!
Heartbeat-1
Heartbeat-2
Heartbeat-1
Heartbeat-2
...
 */