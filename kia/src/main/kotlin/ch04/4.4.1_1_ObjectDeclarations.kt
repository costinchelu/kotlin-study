package ch04.ex4_1_1_ObjectDeclarations

import java.io.File

// defines an object and a class in the same time
// constructors are not allowed (instance is created immediately at the point of definition, not through constructor calls)
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

fun main() {
    // an object declaration lets you call methods and access properties using the object name
    // CaseInsensitiveFileComparator is here a class but also an object

    println(
        CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}
