package ch17

import kia2e.coroutines.getTemperatures
import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

fun main() {
    runBlocking {
        val temps = getTemperatures()
        temps
            .onEach { log("Read $it from sensor") }
            .conflate()
            .collect {
                log("Collected $it")
                delay(1.seconds)
            }
    }
}
/*
23 [main] Read 20 from sensor
35 [main] Collected 20
539 [main] Read 13 from sensor
1037 [main] Collected 13
1041 [main] Read -10 from sensor
1546 [main] Read -5 from sensor
2041 [main] Collected -5
2049 [main] Read -7 from sensor
2555 [main] Read 0 from sensor
3045 [main] Collected 0
3059 [main] Read 27 from sensor
3564 [main] Read 8 from sensor
4049 [main] Collected 8
4069 [main] Read 7 from sensor
4574 [main] Read 30 from sensor
5055 [main] Collected 30

Some of the values are discarded (not collected). If the collector is busy, all the values that are received and
cannot be collected, will be discarded.
Useful when working with flow whose values become out of date, being replaced by other emitted elements.
 */