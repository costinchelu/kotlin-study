package ch16_6_2_ChannelFlow

import ch16_6_1_ChannelFlow.getRandomNumber
import kia2e.coroutines.log
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// using a channelFlow we can run flows concurrently

val randomNumbersInParallel = channelFlow {
    repeat(10) {
        launch {
            send(getRandomNumber())
        }
    }
}

fun main() = runBlocking {
    randomNumbersInParallel.collect { log(it) }
}
/*
0 [main] -1777932454
12 [main] 1533718351
12 [main] 384106862
12 [main] -1134323179
12 [main] -2012747615
12 [main] 509679839
12 [main] 1020343128
12 [main] -1110239496
12 [main] 1590422294
12 [main] 395444473
 */