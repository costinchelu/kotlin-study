package ch16

import kia2e.coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

// cold flow (inert by default until it is collected)
// using the flow factory function
val letters = flow {
    log("Emitting A!")
    emit("A")
    delay(200.milliseconds)
    log("Emitting B!")
    emit("B")
}

fun main() {

    // calling collect {} invokes the body of the flow builder function
    // when the code calls emit it in turn calls the lambda passed to collect with the parameter passed to emit
    // after that the function returns back into the body of the builder function and continues execution

//    runBlocking {
//        letters.collect {
//            log("Collecting $it")
//            delay(500.milliseconds)
//        }
//    }
    /*
    0 [main] Emitting A!
    14 [main] Collecting A
    729 [main] Emitting B!
    729 [main] Collecting B
     */


// can also collect multiple flows
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
    /*
    0 [main] Emitting A!
    15 [main] (1) Collecting A
    727 [main] Emitting B!
    727 [main] (1) Collecting B
    1233 [main] Emitting A!
    1233 [main] (2) Collecting A
    1941 [main] Emitting B!
    1941 [main] (2) Collecting B
     */
}