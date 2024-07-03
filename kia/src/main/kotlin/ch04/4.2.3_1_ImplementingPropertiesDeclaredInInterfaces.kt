package ch04.ex2_3_1_ImplementingPropertiesDeclaredInInterfaces

fun getNameFromSocialNetwork(accountId: Int) = "soc:$accountId"

interface User {
    val nickname: String
}

// initialize nickname in the primary constructor (override property from User)
class PrivateUser(override val nickname: String) : User

// initialize nickname in a custom getter
// here nickname is initialized every time it is accessed
class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

// initialize nickname using a top-level (static) function
// nickname is initialized only once when class is initialized
class SocialUser(accountId: Int) : User {
    override val nickname = getNameFromSocialNetwork(accountId)
}

fun main() {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
    println(SocialUser(15).nickname)
}
