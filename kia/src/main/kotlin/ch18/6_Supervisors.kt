package ch18

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

// with coroutines, we can define boundaries
// supervisors prevents parents and siblings from being cancelled
// SupervisorJob invokes the CoroutineExceptionHandler for child coroutines that were started using the launch builder
fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
            child(300.milliseconds, "Heartbeat-1")
        }

        launch {
            child(500.milliseconds,"Heartbeat-2")
        }

        launch {
            delay(1.seconds)
            throw UnsupportedOperationException("Ow!")
        }
    }
}
/*
Heartbeat-1
Heartbeat-2
Heartbeat-1
Heartbeat-2
Heartbeat-1
Heartbeat-1
Exception in thread "main" java.lang.UnsupportedOperationException: Ow!
	at ch18._6_SupervisorsKt$main$1$1$3.invokeSuspend(6_Supervisors.kt:23)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTaskKt.resume(DispatchedTask.kt:229)
	at kotlinx.coroutines.DispatchedTaskKt.dispatch(DispatchedTask.kt:162)
	at kotlinx.coroutines.CancellableContinuationImpl.dispatchResume(CancellableContinuationImpl.kt:470)
	at kotlinx.coroutines.CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core(CancellableContinuationImpl.kt:504)
	at kotlinx.coroutines.CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(CancellableContinuationImpl.kt:493)
	at kotlinx.coroutines.CancellableContinuationImpl.resumeUndispatched(CancellableContinuationImpl.kt:596)
	at kotlinx.coroutines.EventLoopImplBase$DelayedResumeTask.run(EventLoop.common.kt:497)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:263)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:95)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:69)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:47)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at ch18._6_SupervisorsKt.main(6_Supervisors.kt:11)
	at ch18._6_SupervisorsKt.main(6_Supervisors.kt)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [StandaloneCoroutine{Cancelling}@2752f6e2, BlockingEventLoop@e580929]
Heartbeat-2
Heartbeat-1
Heartbeat-1
Heartbeat-2
...
 */