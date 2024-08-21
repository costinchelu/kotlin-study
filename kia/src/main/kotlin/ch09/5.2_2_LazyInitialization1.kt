package ch09.LazyInitialization1

class Email { /*...*/ }

fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

// using by lazy we can do the same as the custom getter we used before
// by lazy is a delegate
// lazy is a function that returns an object that has a getValue() method
class Person(val name: String) {

    val emails by lazy { loadEmails(this) }
}

fun main() {
    val p = Person("John")
    p.emails    // Load emails for John
    p.emails
}