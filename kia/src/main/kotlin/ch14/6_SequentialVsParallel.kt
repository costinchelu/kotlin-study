package ch14

import kia2e.coroutines.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration.Companion.seconds

// single coroutine on the multithreaded default dispatcher
// its running logic runs sequentially
// 10,000

fun main1() {
    log("start")
    runBlocking {
        launch(Dispatchers.Default) {
            var x = 0
            repeat(10_000) {
                x++
            }
            delay(1.seconds)
            log(x)
        }
    }
}

// 10000 coroutines will increment the same variable (not safe)
// operations run in parallel (because the dispatcher is multithreaded)
// and so some of them will be lost because they will overwrite the same value
// 9638
fun main2() {
    log("start")
    runBlocking {
        var x = 0
        repeat(10_000) {
            launch(Dispatchers.Default) {
                x++
            }
        }
        delay(1.seconds)
        log(x)
    }
}

// one approach of having multiple coroutines working on the same variable is locking the resource
// 10000
fun main3() {
    log("start")
    runBlocking {
        val mutex = Mutex()
        var x = 0
        repeat(10_000) {
            launch(Dispatchers.Default) {
                mutex.withLock {
                    x++
                }
            }
        }
        delay(1.seconds)
        log(x)
    }
}



fun main() {
    main3()
    // in conclusion: when multiple coroutines running in parallel modify the same data,
    // we need to perform synchronization or locking, just like we would do with threads.
}