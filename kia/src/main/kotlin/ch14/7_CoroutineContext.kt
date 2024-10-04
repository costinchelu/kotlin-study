package ch14

import kia2e.coroutines.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

// coroutine context is additional information carried by the coroutine
suspend fun introspect() {
    log(coroutineContext)
}

fun main() {
    runBlocking {
        introspect()
    }
    // [main] [BlockingCoroutine{Active}@3abfe836, BlockingEventLoop@2ff5659e]

    runBlocking(Dispatchers.IO + CoroutineName("Coolroutine")) {
        introspect()
    }
    //[DefaultDispatcher-worker-1] [CoroutineName(Coolroutine), BlockingCoroutine{Active}@68703eea, Dispatchers.IO]
}