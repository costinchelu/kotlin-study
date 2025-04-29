package ro.ccar.kt

interface GenericsExample<out T> {
    fun next(): T
}

class IntGenerator : GenericsExample<Int> {
    private var current = 0

    override fun next(): Int {
        return current++
    }
}

fun main() {
    val intGenerator = IntGenerator()
    println(intGenerator.next())
    println(intGenerator.next())
}