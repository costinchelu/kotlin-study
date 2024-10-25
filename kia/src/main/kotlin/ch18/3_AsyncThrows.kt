package ch18

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

// catching the awaited async response will still not work
// await actually rethrows the exception
// a child coroutine will propagate the exception to its parent coroutine, and it is
// parent's responsibility to catch the exception
fun main(): Unit = runBlocking {
    val myDeferredInt: Deferred<Int> = async {
        throw UnsupportedOperationException("Ouch!")
    }
    try {
        val i: Int = myDeferredInt.await()
        println(i)
    } catch (u: UnsupportedOperationException) {
        println("Handled: $u")
    }
}
/*
Exception in thread "main" java.lang.UnsupportedOperationException: Ouch!
	at ch18._3_AsyncThrowsKt$main$1$myDeferredInt$1.invokeSuspend(3_AsyncThrows.kt:9)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:102)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:263)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:95)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:69)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:47)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at ch18._3_AsyncThrowsKt.main(3_AsyncThrows.kt:7)
	at ch18._3_AsyncThrowsKt.main(3_AsyncThrows.kt)
 */