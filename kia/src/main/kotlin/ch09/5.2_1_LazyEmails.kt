package ch09.LazyEmails

class Email { /*...*/ }

// loading emails is a costly operation (they have to be loaded from a server etc)
fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

// using a getter we can lazy load emails once we need them (they will only be loaded once)
class Person(val name: String) {

    // backing property - only used to store the emails list (initially being null) - it should be private
    private var _emails: List<Email>? = null

    // this property is to provide access to person's emails (public property)
    // this method (using a backing property) is not thread safe
    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!
        }
}

fun main() {
    val p = Person("Alice")
    p.emails    // Load emails for Alice
    p.emails
}
