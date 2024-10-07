package ch15.AssociatingCoroutineScopesWithComponentsCoroutineScope

import kia2e.coroutines.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds


// SupervisorJob is a kind of job that prevents uncaught exceptions from cancelling
// other coroutines associated with the same scope and propagating the exception further
// basically it associates coroutines with the lifecycle of a class
// CoroutineScope != coroutineScope()
class ComponentWithScope(dispatcher: CoroutineDispatcher = Dispatchers.Default) {

    private val scope = CoroutineScope(dispatcher + SupervisorJob())

    fun start() {
        log("Starting!")
        scope.launch {
            while (true) {
                delay(500.milliseconds)
                log("Component working!")
            }
        }
        scope.launch {
            log("Doing a one-off task...")
            delay(500.milliseconds)
            log("Task done!")
        }
    }

    fun stop() {
        log("Stopping!")
        scope.cancel()
    }
}

fun main() {
    val c = ComponentWithScope()
    c.start()
    Thread.sleep(2100)
    c.stop()
}
