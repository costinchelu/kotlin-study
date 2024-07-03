package ch04.ex2_4_1_AccessingABackingFieldFromAGetterOrSetter

class User(val name: String) {

    // field and value are specific keywords
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value".
                """.trimIndent()
            )
            field = value
        }
}

// here, the setter, will set the value of the ageIn2050 variable, but will also change birthYear too
class Person(var birthYear: Int) {
    var ageIn2050
        get() = 2050 - birthYear
        set(value) {
            birthYear = 2050 - value
        }
}

fun main() {
    val user = User("Alice")

    // invokes the setter under the hood
    user.address = "Christoph-Rapparini-Bogen 23, 80639 Munchen"

    val person = Person(1980)
    println(person.ageIn2050)
    person.ageIn2050 = 80
    println(person.birthYear)
}
