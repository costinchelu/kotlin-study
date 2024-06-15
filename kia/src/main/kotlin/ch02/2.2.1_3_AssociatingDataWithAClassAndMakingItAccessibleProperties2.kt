package ch02.ex2_1_3_AssociatingDataWithAClassAndMakingItAccessibleProperties2

// getters are created by default
// setters are created by default for var types
class Person(
    val name: String,
    var isStudent: Boolean
)

fun main() {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isStudent)
    person.isStudent = false
    println(person.isStudent)
}
