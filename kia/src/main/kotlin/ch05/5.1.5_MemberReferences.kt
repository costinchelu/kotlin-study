package ch05.ex1_5_1_MemberReferences

import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2

fun salute() = println("Salute!")

data class Person(val name: String, val age: Int)

// extension function:
fun Person.isAdult(): Boolean = age >= 21

fun main() {
    // for a top level reference of a function :
    run(::salute)

    // constructor reference (storing and postponing the action of creating an instance
    val createPerson: KFunction2<String, Int, Person> = ::Person
    val p: Person = createPerson("Alice", 29)

    // reference extension function:
    val predicate: KFunction1<Person, Boolean> = Person::isAdult

    println(p)
    println(predicate)
}
