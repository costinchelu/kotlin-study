package ch07.ex1_5_SafelyCastingValuesWithoutThrowingExceptionsAs


// the safe-cast operator as? gives you the tools to safely work with the possibility that a cast may not succeed.
// It tries to cast a value to the given type and returns null if the type differs.
class Person(val firstName: String, val lastName: String) {

    override fun equals(other: Any?): Boolean {
        val otherPerson: Person = other as? Person ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
//        val otherPerson: Person? = other as? Person
//        return otherPerson?.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun main() {
    val p1 = Person("Dmitry", "Jemerov")
    val p2 = Person("Dmitry", "Jemerov")
    println(p1 == p2)
    println(p1.equals(42))
}
