package ch17

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun getAllUserIds(): Flow<Int> {
    return flow {
        repeat(3) {
            delay(200.milliseconds) // Database latency
            log("Emitting!")
            emit(it)
        }
    }
}

suspend fun getProfileFromNetwork(id: Int): String {
    delay(2.seconds) // Network latency
    return "Profile[$id]"
}

// we have a cold flow of values received from DB, but the network is slow. We can keep the values in a buffer
fun main() {
    val ids = getAllUserIds()
    runBlocking {
        ids
            .buffer(3)
            .map { getProfileFromNetwork(it) }
            .collect { log("Got $it") }
    }
/*
    0 [main] Emitting!
    212 [main] Emitting!
    413 [main] Emitting!
    2027 [main] Got Profile[0]
    4034 [main] Got Profile[1]
    6038 [main] Got Profile[2]
*/
}

/*
Without the buffer we would have:

0 [main] Emitting!
2026 [main] Got Profile[0]
2232 [main] Emitting!
4238 [main] Got Profile[1]
4444 [main] Emitting!
6446 [main] Got Profile[2]

so for each slow network operation, db will wait for previous profile to be collected.
 */