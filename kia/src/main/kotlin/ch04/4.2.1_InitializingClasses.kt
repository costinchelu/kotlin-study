package ch04.ex2_1_InitializingClasses

import java.net.URI

// class with primary constructor (in most cases, constructors are straight-forward - just initiating some values)
// isSubscribed also having a default value
open class User(val nickname: String,
           val isSubscribed: Boolean = true)


// if we need Java to call constructor with default parameters, Kotlin can create the whole set of possible
// constructors using @JvmOverloads annotation (can be applied on functions and constructors)

// if we are extending a class that has a constructor with arguments, then we need to init them
// even if the superclass have a no-arg constructor, we will still need : Superclass()
// we can observe that because interfaces don't have constructors we don't need the round brackets
class SocialUser(nicknameSu: String) : User(nicknameSu)


// there is also the possibility to have a private primary constructor
class Secret
    private constructor(private val url: String, val pass: String)


// there is an expanded form too, using a secondary constructor:
class UserExp
    constructor(nickname: String, isSubscribed: Boolean) {

        val nickname: String

        val isSubscribed: Boolean

        init {
            this.nickname = nickname
            this.isSubscribed = isSubscribed
        }
    }

// or a semi-expanded form:
class UserExp2(nickNameIn: String, isSubscribedIn: Boolean) {

    val nickname = nickNameIn
    val isSubscribed = isSubscribedIn
}


// there are cases when multiple constructors are required:
open class Downloader {

    constructor(url: String)

    constructor(uri: URI)
}

// we can use just one of the superclass constructors
class MyDownloader(myUrl: String) : Downloader(myUrl)


// or we need to create 2 constructors same as superclass
class AnotherDownloader : Downloader {

    constructor(url: String) : super(url)

    constructor(uri: URI) : super(uri)
}

// or we can call another constructor of the same class
class ExtraDownloader : Downloader {

    constructor(uri: URI) : super(uri)

    constructor(url: String) : this(URI(url))
}



fun main() {
    // no "new" in the calling of the constructor
    val alice = User("Alice")
    println(alice.isSubscribed)
    val bob = User("Bob", false)
    println(bob.isSubscribed)
    // we can explicit specify argument names
    val carol = User(nickname = "Carol", isSubscribed = false)
    println(carol.isSubscribed)
    println(carol.nickname)
}