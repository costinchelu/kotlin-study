package ch14.SuspendAndOtherApproaches

import io.reactivex.rxjava3.core.Single
import java.util.concurrent.CompletableFuture

class Credentials
class UserID
class UserData

// non-blocking implementation (suspend) - indicates that this function may pause execution
suspend fun login(credentials: Credentials): UserID = UserID()
suspend fun loadUserData(userID: UserID): UserData = UserData()
fun showData(data: UserData) = println()

suspend fun showUserInfo(credentials: Credentials) {
    val userID = login(credentials)
    val userData = loadUserData(userID)
    showData(userData)
}

// suspend function can only be called from a coroutine or another suspend function
suspend fun someOtherSuspendingFun() {
    showUserInfo(Credentials())
}


// callback method - susceptible to callback hell
fun loginAsync(credentials: Credentials, callback: (UserID) -> Unit) = UserID()
fun loadUserDataAsync(userID: UserID, callback: (UserData) -> Unit) = UserData()

fun showUserInfoCallBack(credentials: Credentials) {
    loginAsync(credentials) { loadUserDataAsync(it) { userData -> showData(userData) } }
}


// using futures - supplementary operations - nesting data into CompletableFuture
fun loginAsync2(credentials: Credentials): CompletableFuture<UserID> = CompletableFuture<UserID>()
fun loadUserDataAsync2(userID: UserID): CompletableFuture<UserData> = CompletableFuture<UserData>()

fun showUserInfoFutures(credentials: Credentials) {
    loginAsync2(credentials)
        .thenCompose { loadUserDataAsync2(it) }
        .thenAccept { showData(it) }
}


// reactive approach RxJava - still requires signature change
fun loginReactive(credentials: Credentials): Single<UserID> = Single.just(UserID())
fun loadUserDataReactive(userID: UserID): Single<UserData> = Single.just(UserData())

fun showUserInfoReactive(credentials: Credentials) {
    loginReactive(credentials)
        .flatMap { loadUserDataReactive(it) }
        .doOnSuccess { showData(it) }
        .subscribe()
}