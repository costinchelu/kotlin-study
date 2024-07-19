package ch04.ex4_2_1_CompanionObjects


// Kotlin doesn't have a static keyword
// it relies on package-level functions (replace static methods) and object declarations
// (replace static methods and static fields)
// but top-level functions can't access private members of a class
// we can use companion objects to access members of an object directly to name of the containing class
// without specifying the name of the object explicitly
class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}


fun buildNameFromId(accountId: Int) = "soc:$accountId"


// the companion object will have access to all private members of the class
// here is a case of using companion object for factory methods (private constructor, can't be called outside class)
// a companion object is a regular object declared in a class
class User private constructor(val username: String) {
    
    companion object UserFactory {
        fun fromEmail(email: String) = User(email.substringBefore('@'))
        fun fromId(accountId: Int) = User(buildNameFromId(accountId))
    }
}

fun User.UserFactory.printMessage() = println("Calling companion's extension function")


interface MouseListener {
    fun onClick()
}

class Button(private val listener: MouseListener)


fun main() {
    A.bar()

    val subscribingUser = User.fromEmail("bob@gmail.com")
    val socialUser = User.fromId(4)
    println("username: ${subscribingUser.username} (${subscribingUser.javaClass.name})")
    println("username: ${socialUser.username} (${subscribingUser.javaClass.name})")
    // Companion object's extension function can be called directly through the class
    User.printMessage()

    // implementing an ad-hoc object (like an anonymous class in Java)
    // anonymous objects are not singletons
    // object expression declares a class and creates an instance of that class
    Button(object : MouseListener {
        override fun onClick() {
            println("Button clicked")
        }
    })
}
