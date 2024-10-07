package ch15JobsCoroutineScope

import kia2e.coroutines.log
import kotlinx.coroutines.*

// coroutine relations
@OptIn(ExperimentalCoroutinesApi::class)
fun main() {

    runBlocking(CoroutineName("A")) {
        log("A's job: ${coroutineContext.job}")
        launch(CoroutineName("B")) {
            log("B's job: ${coroutineContext.job}")
            log("B's parent: ${coroutineContext.job.parent}")
        }
        log("A's children: ${coroutineContext.job.children.toList()}")
    }
    /*
    [main] A's job: BlockingCoroutine{Active}@e6ea0c6
    [main] A's children: [StandaloneCoroutine{Active}@12bc6874]
    [main] B's job: StandaloneCoroutine{Active}@12bc6874
    [main] B's parent: BlockingCoroutine{Completing}@e6ea0c6
     */


    runBlocking<Unit> {
        log("A's job: ${coroutineContext.job}")
        coroutineScope {
            log("B's parent: ${coroutineContext.job.parent}")
            log("B's job: ${coroutineContext.job}")
            launch {
                log("C's parent: ${coroutineContext.job.parent}")
            }
        }
        /*
       [main] A's job: BlockingCoroutine{Active}@7b3300e5
       [main] B's parent: BlockingCoroutine{Active}@7b3300e5
       [main] B's job: ScopeCoroutine{Active}@424c0bc4
       [main] C's parent: ScopeCoroutine{Completing}@424c0bc4
        */

    }
}
