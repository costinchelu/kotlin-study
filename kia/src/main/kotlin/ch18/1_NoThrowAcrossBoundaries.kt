package ch18

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// normal try-catch mechanisms will not work with coroutines
// this code will throw an exception regardless
fun main(): Unit = runBlocking {
    try {
        launch {
            throw UnsupportedOperationException("Ouch!")
        }
    } catch (u: UnsupportedOperationException) {
        println("Handled $u")
    }
}
/*
Exception in thread "main" java.lang.UnsupportedOperationException: Ouch!
	at ch18._1_NoThrowAcrossBoundariesKt$main$1$1.invokeSuspend(1_NoThrowAcrossBoundaries.kt:11)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:102)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:263)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:95)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:69)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:47)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at ch18._1_NoThrowAcrossBoundariesKt.main(1_NoThrowAcrossBoundaries.kt:8)
	at ch18._1_NoThrowAcrossBoundariesKt.main(1_NoThrowAcrossBoundaries.kt)
 */