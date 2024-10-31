package ch183

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

class ComponentWithScope(dispatcher: CoroutineDispatcher = Dispatchers.Default) {

    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        println("[ERROR] ${e.message}")
    }

    private val scope = CoroutineScope(SupervisorJob() + dispatcher + exceptionHandler)

    // starting the coroutine with async - we can't see the exc handler invoked
    // because by starting with async, it becomes the responsibility of the consumer of the Deferred to handle this exception by calling await()
    fun action() = scope.async {
        launch {
            throw UnsupportedOperationException("Ouch!")
        }
    }
}


fun main() = runBlocking {
    val supervisor = ComponentWithScope()
    supervisor.action()
    delay(1.seconds)
}