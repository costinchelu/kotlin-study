package ch04.ex4_1_1_ObjectDeclarations

import java.io.File

// defines an object and a class in the same time
// constructors are not allowed (instance is created immediately at the point of definition, not through constructor calls)
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(f1: File, f2: File): Int {
        return f1.path.compareTo(f2.path, ignoreCase = true)
    }
}

// an object declaration in Kotlin is compiled as a class with a static field holding its single
// instance, which is always named INSTANCE
// Person.NameComparator.INSTANCE.compare(p1, p2)
data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }
}

fun main() {
    // an object declaration lets you call methods and access properties using the object name
    // CaseInsensitiveFileComparator is here a class but also an object

    println(
        CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))


    val persons = listOf(
        Person("Bob"),
        Person("Alice")
    )
    println(persons.sortedWith(Person.NameComparator))
}
