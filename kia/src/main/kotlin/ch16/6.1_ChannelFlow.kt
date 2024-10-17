package ch16_6_1_ChannelFlow

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

// normally all operations will run sequentially:

suspend fun getRandomNumber(): Int {
    delay(500.milliseconds)
    return Random.nextInt()
}

val randomNumbersSequentially = flow {
    repeat(10) {
        emit(getRandomNumber())
    }
}

fun main() = runBlocking {
    randomNumbersSequentially.collect { log(it) }
}
/*
0 [main] 178667107
522 [main] -165733320
1028 [main] 913688414
1533 [main] -186464921
2039 [main] 558550217
2544 [main] -216189244
3047 [main] -1331027860
3549 [main] 558314363
4055 [main] -377957500
4561 [main] -1113054126
 */

// but we can do them to run in parallel (6.2)